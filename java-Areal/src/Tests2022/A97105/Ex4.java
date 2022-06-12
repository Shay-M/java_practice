package Tests2022.A97105;

public class Ex4 {

    public static class A {
        public static int countA = 0;
        private int myVal;
        public int myValpub;
        protected String myString;

        public A() {
            myVal = 1;
            func();
        }

        public A(int val) {
            myVal = val;
            myString = "GOOD!";
            func();
        }

        public void func() {
            countA++;
            System.out.println("YES");
        }
    }

    public static class B extends A {
        public static int countB = 0;

        public B(int val, double x) {
            super(val);
            this.x = x;
        }

        @Override
        public void func() {
            countB++;
        }


        private double x;

        public boolean goodCode() {
            return x > 15.0;
        }
    }

    public static void main(String args[]) {
        A obj1 = new A(1);
        B obj2 = new B(1, 1.1);

        obj1.myString = "hi";
        obj2.myString = "hi";

        obj1.myVal = 1;
//        obj2.myVal = 1; //'myVal' has private access in 'A'
        obj2.myValpub = 2;

        System.out.println("countA: " + A.countA);
        System.out.println("countB: " + B.countB);

    }

}
