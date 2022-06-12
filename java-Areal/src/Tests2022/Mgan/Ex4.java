package Tests2022.Mgan;

public class Ex4 {


    public static void main(String[] args) {
        Circle c = new Circle();

//        Shape s = new Circle();
    }

    abstract static class Shape {
        public Shape() {
            System.out.println("YAA its cool");
            calc();
        }

        public void calc() {
            System.out.println("safe side");
        }
    }

    static class Circle extends Shape {
        private Boy b; // cannot find symbol

        public Circle() {
            b = new Boy();
            System.out.println("it’s a Boy");
        }

        public void calc() {
            System.out.println("I don’t like java ");
        }
    }
}
