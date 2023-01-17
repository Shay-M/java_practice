package gameoflife.model;

public final class Grid { // <T>
    private final boolean[][] matrix;
    private final int m_width;
    private final int m_height;

    public Grid(final int height, final int width) {
        this.m_height = height;
        this.m_width = width;

        matrix = new boolean[m_width][m_height];

    }

}
