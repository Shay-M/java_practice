package gameoflife.model;

import java.security.SecureRandom;

public final class Grid<T> { // <T>
    private static final int[][] NEIGHBOR_WINDOW = { // todo remove from this
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};
    //private final T[][] matrix;
    private final boolean[][] matrix;
    private final int m_width;
    private final int m_height;

    public Grid(final int height, final int width) {
        this.m_height = height;
        this.m_width = width;

        matrix = new boolean[m_width][m_height];
//        var m = new Object[m_width][m_height];
//        matrix = (T[][]) m;
    }

    public void initializeFirstGeneration(final double initialPopulation) {
        final SecureRandom secureRandom = new SecureRandom();
        for (int row = 0; row < m_width; ++row) {
            for (int col = 0; col < m_height; ++col) {
                matrix[row][col] = secureRandom.nextDouble() < initialPopulation; // todo not good
            }
        }
    }

    public int countLiveNeighbors(final int row, final int col) {
        int count = 0;
        for (int[] offset : NEIGHBOR_WINDOW) {
            int neighborRow = row + offset[0];
            int neighborCol = col + offset[1];

            if (neighborRow >= 0 && neighborRow < m_width && // outside 'width' bound of the grid
                    neighborCol >= 0 && neighborCol < m_height && // outside 'height' bound of the grid
                    matrix[neighborRow][neighborCol]) // now position is alive?
            {
                ++count;
            }
        }
        return count;
    }

    public int getWidth() {
        return m_width;
    }

    public int getHeight() {
        return m_height;
    }

    public void set(final int x, final int y, final boolean value) {
        matrix[x][y] = value;
    }

    public boolean get(final int x, final int y) {
        return matrix[x][y];
    }

    public boolean[] getRow(final int rowIndex) {
        return matrix[rowIndex];
    }

}
