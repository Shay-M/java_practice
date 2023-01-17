package gameoflife;

import gameoflife.files.FrameWriter;
import gameoflife.model.Grid;

import java.nio.file.Path;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public final class LifeT {
    private static final Logger m_logger = Logger.getLogger(LifeT.class.getCanonicalName());
    private static final String TYPE_FILE = ".pbm";
    private static final String DEFAULT_OUTPUT_FOLDER = "output";
    private static final String DEFAULT_FILE_NAME = "generation_";
    private static final int DEFAULT_ITERATIONS = 20;
    private static final int DEFAULT_THREADS = 2;
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 800;
    private static final double INITIAL_POPULATION = 0.2;

    private final Path m_filePath;
    private final int m_width;
    private final int m_height;
    private final int m_iterations;
    private final int m_numThreads;

    private String m_fileName;
    private Grid<Boolean> m_currentGeneration;
    private Grid<Boolean> m_nextGeneration;
    private FrameWriter m_files;

    public static void main(final String[] args) {
        int index = 0;
        try {
            final LifeT lifeGame;
            final var filePath = Path.of(args[index++]);
            final var iterations = Integer.parseInt(args[index++]);
            final var numThreads = Integer.parseInt(args[index++]);
            final var width = Integer.parseInt(args[index++]);
            final var height = Integer.parseInt(args[index++]);
            // assert args.length == index;
            if (args.length == 0) {
                lifeGame = new LifeT(filePath, width, height, iterations, numThreads);
            }
            else {
                lifeGame = new LifeT();
            }
            lifeGame.start();
        }
        catch (NumberFormatException ex) {
            m_logger.log(Level.INFO, "use default.");
        }
    }

    public LifeT() {
        this.m_filePath = Path.of(DEFAULT_OUTPUT_FOLDER);
        this.m_width = DEFAULT_WIDTH;
        this.m_height = DEFAULT_HEIGHT;
        this.m_iterations = DEFAULT_ITERATIONS;
        this.m_numThreads = DEFAULT_THREADS;
    }

    public LifeT(final Path m_filePath, final int m_width, final int m_height, final int m_iterations, final int m_numThreads) {
        this.m_filePath = m_filePath;
        this.m_width = m_width;
        this.m_height = m_height;
        this.m_iterations = m_iterations;
        this.m_numThreads = m_numThreads;
    }

    private void start() {
        m_files = new FrameWriter(m_filePath);
        m_files.createTheOutputDirectory();

        m_currentGeneration = new Grid<Boolean>(m_height, m_width);
        m_currentGeneration.initializeFirstGeneration(INITIAL_POPULATION);
        m_nextGeneration = new Grid<Boolean>(m_height, m_width);

        m_fileName = !m_filePath.getFileName().toString().isEmpty() ? m_filePath.getFileName().toString() : DEFAULT_FILE_NAME;

        simulateIterationsGenerations();
    }

    private void simulateIterationsGenerations() {
        for (int generationNumber = 0; generationNumber < m_iterations; ++generationNumber) {
            simulateOneGeneration();
            m_files.saveCurrentGenerationToFile(generationNumber, m_currentGeneration, TYPE_FILE, m_fileName);

            // copyNextGenerationToCurrent();
            var temp = m_currentGeneration;
            m_currentGeneration = m_nextGeneration;
            m_nextGeneration = temp;
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

        for (int i = 0; i < m_numThreads; ++i) {
            int startRow = i * sizeGridThread;
            int endRow = startRow + sizeGridThread - 1;
            new Thread(() -> simulateGrid(startRow, endRow, cyclicBarrier)).start(); // todo
        }
    }

    private void simulateGrid(final int startRow, final int endRow, final CyclicBarrier cyclicBarrier) {
        for (int row = startRow; row < endRow; row++) {
            for (int col = 0; col < m_height; col++) {
                int numNeighbors = m_currentGeneration.countLiveNeighbors(row, col);
                if (m_currentGeneration.get(row, col)) {
                    // Any 'live' cell with two or three live neighbours survives.
                    m_nextGeneration.set(row, col, numNeighbors == 2 || numNeighbors == 3);
                }
                else {
                    // Any 'dead' cell with three live neighbours becomes a live cell.
                    m_nextGeneration.set(row, col, numNeighbors == 3);
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

//    private void copyNextGenerationToCurrent() {
//        for (int row = 0; row < m_width; ++row) {
//            System.arraycopy(m_nextGeneration.getRow(row), 0, m_currentGeneration.getRow(row), 0, m_height);
//        }
//    }

}
