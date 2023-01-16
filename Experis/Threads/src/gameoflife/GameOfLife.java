package gameoflife;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

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

public class GameOfLife {
    private static final int DEFAULT_ITERATIONS = 20;
    private static final int DEFAULT_THREADS = 2;
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 800;
    private static final double INITIAL_POPULATION = 0.3;
    private static final int[][] NEIGHBOR_WINDOW = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};

    private static int m_iterations;
    private static int m_numThreads; // todo
    private static int m_width;
    private static int m_height;
    private static String m_filename;
    private static boolean[][] m_currentGeneration;
    private static boolean[][] m_nextGeneration;

    public static void main(String[] args) {
        parseArguments(args);
        createTheOutputDirectory();

        m_currentGeneration = new boolean[m_width][m_height];
        m_nextGeneration = new boolean[m_width][m_height];
        initializeFirstGeneration();
        simulateForIterationsGenerations();
    }

    private static void parseArguments(final String[] args) {
        // assert args.length > 0;
        m_filename = args.length > 0 ? args[0] : "output";
        m_iterations = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_ITERATIONS;
        m_numThreads = args.length > 2 ? Integer.parseInt(args[2]) : DEFAULT_THREADS;
        m_width = args.length > 3 ? Integer.parseInt(args[3]) : DEFAULT_WIDTH;
        m_height = args.length > 4 ? Integer.parseInt(args[4]) : DEFAULT_HEIGHT;
    }

    private static void createTheOutputDirectory() {
        final Path outputDir = Paths.get(m_filename);
        if (!Files.exists(outputDir)) {
            try {
                Files.createDirectory(outputDir);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void initializeFirstGeneration() {
        final SecureRandom secureRandom = new SecureRandom();
        for (int row = 0; row < m_width; row++) {
            for (int col = 0; col < m_height; col++) {
                m_currentGeneration[row][col] = secureRandom.nextDouble() < INITIAL_POPULATION;
            }
        }
    }


}
