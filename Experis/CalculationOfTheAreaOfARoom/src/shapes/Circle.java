package shapes;

public class Circle implements Shape {

    private final double m_radius;

    public Circle(final double radius) {
        m_radius = radius;
    }

    @Override
    public double calculateSize() {
        return (m_radius * m_radius) * Math.PI;
    }
}
