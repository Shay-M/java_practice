package Tests2022.Mgan2;

public class Shape {
    public int y;
    public int x;
    public String color;

    public Shape() {
    }

    public Shape(int y, int x) {

    }

    public Shape(String color) {

    }

    public Shape(int y, int x, String color) {

    }

    protected int layer() {
        return 0;
    }

    protected void hit() {
        System.out.println("hit S");
    }

    protected void print(double r) {
    }

    protected void move() {
        System.out.println("move ");

    }
}
