package Tests2022.B97105;

public class Ex3 {

    public static class One {
        private int num1 = 0;
        private int num2 = 0;
        protected static int count = 0;

        public One(int num) {
            this.num1 = num;
            this.num2 = num;
            count++;
            System.out.println("One ctor1");
        }

        public One(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            count++;
            System.out.println("One ctor2");
        }

        public int sum() {
            return this.num1 + this.num2;
        }

        public void setNum(int num) {
            this.num2 = num;
        }

        public static int getCount() {
            return count;

        }
    }
    // end of class One

    public static class Two extends One {
        private int num3 = 0;

        public Two(int num) {
            super(num);
            this.num3 = num;
            System.out.println("Two ctor1");
        }

        public Two(int num1, int num2, int num3) {
            super(num1, num2);
            this.num3 = num3;
            System.out.println("Two ctor2");
        }

        public int sum() {
            return super.sum() + this.num3;
        }

        public void setNum(int num) {
            this.num3 = num;
        }

        public static int getCount() {
            return count;
        }
    }


    //    public class Run {
    public static void main(String[] args) {
        One f1 = new One(10);
        One f2 = new One(10, 20);
        Two s1 = new Two(1);

        One f3 = new Two(2);

        System.out.println("count= " + One.getCount());
        f2 = s1;
        System.out.println("sum= " + f2.sum());

        s1.setNum(2);
        System.out.println("sum= " + s1.sum());
        System.out.println("sum= " + f2.sum());
        f2.setNum(4);
        System.out.println("sum= " + f2.sum());
        f1.setNum(4);
        System.out.println("sum= " + f1.sum());

        System.out.println("count= " + Two.getCount());
//        }
    }
}
// end of class Two

/*
One ctor1
One ctor2
One ctor1
Two ctor1
One ctor1
Two ctor1
count= 4
sum= 3
sum= 4
sum= 4
sum= 6
sum= 14
count= 4
*/
