package gameoflife;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
simulate a game of life and save each generation as a pbm file.
simulation will be on a grid of W * H cells.
computation will be done using n threads ( by default n=2 )
the threads will be created once for all the life time of the simulation.
( do not create threads for each iteration ).
each iteration will result in a generation that we will save to a file named : life.001.pbm
with a running number for the frame sequence. The file will be formatted according to the format specified in https://en.wikipedia.org/wiki/Netpbm#PBM_example
the program shall take the following as arguments:

java Life filename iters threads   width height

filename: base file name for thee frames
iter: number of frames to create, default to 20
threads: number of threads to use, default to 2
width: width of the frame, default to 900
height: height of the frame, default to 800
*/

public final class LifeWithThreads {
    private static final String TYPE_FILE = ".pbm";
    private static final String DEFAULT_OUTPUT_FOLDER = "output";
    private static final String DEFAULT_FILE_NAME = "generation_";
    private static final int DEFAULT_ITERATIONS = 20;
    private static final int DEFAULT_THREADS = 2;
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 800;
    private static final double INITIAL_POPULATION = 0.2;
    private static final int[][] NEIGHBOR_WINDOW = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};

    private final Path m_filePath;
    private final int m_width;
    private final int m_height;
    private final int m_iterations;
    private final int m_numThreads;
    private final String m_fileName;
    private final boolean[][] m_currentGeneration;
    private final boolean[][] m_nextGeneration;

    public StringBuilder getForTest() {
        return forTest;
    }

    private StringBuilder forTest = new StringBuilder();

    public static void main(final String[] args) {
        int index = 0;
        var filePath = Path.of(args[index++]);
        var iterations = Integer.parseInt(args[index++]);
        var numThreads = Integer.parseInt(args[index++]);
        var width = Integer.parseInt(args[index++]);
        var height = Integer.parseInt(args[index++]);
        assert args.length == index;

        final LifeWithThreads lifeGame = new LifeWithThreads(filePath, width, height, iterations, numThreads);
        lifeGame.Start();
    }

    public LifeWithThreads() {
        this.m_filePath = Path.of(DEFAULT_OUTPUT_FOLDER);
        this.m_width = DEFAULT_WIDTH;
        this.m_height = DEFAULT_HEIGHT;
        this.m_iterations = DEFAULT_ITERATIONS;
        this.m_numThreads = DEFAULT_THREADS;
        m_currentGeneration = new boolean[m_width][m_height];
        m_nextGeneration = new boolean[m_width][m_height];

        m_fileName = !m_filePath.getFileName().toString().isEmpty() ? m_filePath.getFileName().toString() : DEFAULT_FILE_NAME;
    }


    // java Life 'movie/frame' '100' '4'  '200' '200'
    // java Life '200'
    public LifeWithThreads(final Path m_filePath, final int m_width, final int m_height, final int m_iterations, final int m_numThreads) {
        this.m_filePath = m_filePath;
        this.m_width = m_width;
        this.m_height = m_height;
        this.m_iterations = m_iterations;
        this.m_numThreads = m_numThreads;
        m_currentGeneration = new boolean[m_width][m_height];
        m_nextGeneration = new boolean[m_width][m_height];

        m_fileName = !m_filePath.getFileName().toString().isEmpty() ? m_filePath.getFileName().toString() : DEFAULT_FILE_NAME;
    }

    private final void Start(){
        createTheOutputDirectory();
        initializeFirstGeneration();
        simulateIterationsGenerations();
    }

    private void createTheOutputDirectory() {
        // java Life movie/frame 100 4  200 200
        final Path outputDir = m_filePath;
        if (!Files.exists(outputDir)) {
            try {
                // Files.createDirectory(outputDir.getParent());
                Files.createDirectories(outputDir);
            }
            catch (IOException ex) {
                throw new CreateFolderException(ex);
            }
        }
    }

    private void initializeFirstGeneration() {
        final SecureRandom secureRandom = new SecureRandom();
        for (int row = 0; row < m_width; row++) {
            for (int col = 0; col < m_height; col++) {
                m_currentGeneration[row][col] = secureRandom.nextDouble() < INITIAL_POPULATION;
            }
        }
    }

    private void simulateIterationsGenerations() {
        for (int generationNumber = 0; generationNumber < m_iterations; generationNumber++) {
            simulateOneGeneration();
            saveCurrentGenerationToFile(generationNumber);
            copyNextGenerationToCurrent();
        }
    }


    /*
    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    Any live cell with two or three live neighbours lives on to the next generation.
    Any live cell with more than three live neighbours dies, as if by overpopulation.
    */
    private void simulateOneGeneration() {
        final int sizeGridThread = m_width / m_numThreads;
        final var cyclicBarrier = new CyclicBarrier(m_numThreads);

//        int startLocation = 0;
//        int endLocation = 0;
//        for (int i = 0; i < m_numThreads; ++i) {
//            endLocation += sizeGridThread;
//            if (i == m_numThreads - 1) {
//                endLocation = m_width;
//            }

        for (int i = 0; i < m_numThreads; ++i) {
            int startRow = i * sizeGridThread;
            int endRow = startRow + sizeGridThread - 1;
            new Thread(() -> simulateGrid(startRow, endRow, cyclicBarrier)).start();
        }
    }

    private void simulateGrid(final int startRow, final int endRow, final CyclicBarrier cyclicBarrier) {
        for (int row = startRow; row < endRow; row++) {
            for (int col = 0; col < m_height; col++) {
                int numNeighbors = countLiveNeighbors(row, col);
                if (m_currentGeneration[row][col]) {
                    // Any 'live' cell with two or three live neighbours survives.
                    m_nextGeneration[row][col] = numNeighbors == 2 || numNeighbors == 3;
                }
                else {
                    // Any 'dead' cell with three live neighbours becomes a live cell.
                    m_nextGeneration[row][col] = numNeighbors == 3;
                }
            }
        }
        // wait all threads to finish
        try {
            cyclicBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException ex) {
            throw new CyclicBarrierException(ex);
        }
    }

    private int countLiveNeighbors(final int row, final int col) {
        int count = 0;
       /* {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1}};*/
        for (int[] offset : NEIGHBOR_WINDOW) {
            int neighborRow = row + offset[0];
            int neighborCol = col + offset[1];

            if (neighborRow >= 0 && neighborRow < m_width && // outside 'width' bound of the grid
                    neighborCol >= 0 && neighborCol < m_height && // outside 'height' bound of the grid
                    m_currentGeneration[neighborRow][neighborCol]) // now position is alive?
            {
                ++count;
            }
        }
        return count;
    }

    private void copyNextGenerationToCurrent() {
        for (int row = 0; row < m_width; row++) {
            System.arraycopy(m_nextGeneration[row], 0, m_currentGeneration[row], 0, m_height);
        }
    }

    // https://stackoverflow.com/questions/30490471/how-do-i-save-a-bufferedimage-to-a-pgm-file
    private void saveCurrentGenerationToFile(final int generation) {
        final StringBuilder stringBuilder = new StringBuilder();

        // write the PBM header
        stringBuilder.append("P1\n");
        stringBuilder.append(m_height).append(" ").append(m_width).append("\n");

        // write the grid data
        for (int row = 0; row < m_width; row++) {
            for (int col = 0; col < m_height; col++) {
                stringBuilder.append(m_currentGeneration[row][col] ? "1 " : "0 ");
            }
            stringBuilder.append("\n");
        }
        forTest = stringBuilder;

        final Path outputFile = Paths.get(m_filePath.toString(),
                m_fileName + generation + TYPE_FILE);
        try {
            Files.write(outputFile, stringBuilder.toString().getBytes());
        }
        catch (IOException ex) {
            throw new WriteToFileException(ex);
        }
    }
}
