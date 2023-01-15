package shapes;

public class Rectangle implements Shape {

    private final double m_width;
    private final double m_high;

    public Rectangle(final double width, final double high) {
        this.m_width = width;
        this.m_high = high;
    }

    @Override
    public double calculateSize() {
        return m_width * m_high;
    }

}
