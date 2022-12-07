package Tests2022.Mgan2;

public class Ex5b {

    public static class Circle extends Shape {
        private double r = 0;

        public Circle(String color, int x, int y) {
            super(y, x, color);
            this.r = 10;
            System.out.println(this.r);
        }

        public Circle(String color) {
            super(color);
            this.r = 4;
        }

        public Circle(int x, int y) {
            super(y, x);
            this.r = 0;
        }

        public double getRadiusAndPrint() {
            super.print(this.r);
            return this.r;
        }

        public int info() {
            System.out.println(this.color);
            return this.layer();
        }

        public void hit(int a, double b) {
            super.hit();

            this.x += a;
            this.y += b;

        }

        public void move() {
            super.move();
            System.out.println("move Circle");

        }
    }

    public static void main(String[] args) {
//        Circle a = new Circle(1, 4);
//        a.move(1,1);


        Shape a = new Shape(1, 4);
        Circle aa = new Circle("", 1, 4);

        //aa.move(1, 1);
        //aa.hit(1, 1);

        hits(new Object[]{a, aa});
    }

    public static void hits(Object[] arr) {

        for (int i = 0; i < arr.length; i++)
            if (arr[i] instanceof Circle)
                ((Circle) arr[i]).move();
            else ((Shape) arr[i]).move();

            // or
        for (Object o : arr)
            if (o instanceof Circle)
                ((Circle) o).move();
            else ((Shape) o).move();

    }

}
