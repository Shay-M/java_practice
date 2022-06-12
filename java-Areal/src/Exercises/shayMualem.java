package Exercises;

// https://www.geeksforgeeks.org/dynamic-method-dispatch-runtime-polymorphism-java/
public class shayMualem {

    public static class A {
        public static int countA = 0;
        private int myVal;
        public int myValpub;
        protected String myString;

        public A() {

        }

        public A(int val) {
            myVal = val;
            myString = "GOOD!";
        }

        public void _func() {
            countA++;
            System.out.println("_func from A");
        }

        public void _onAB() {
            System.out.println("_onAB from A");
        }

        public void thisIsPrivateA() {

        }
    }

    public static class B extends A {
        public static int countB = 0;
        private double x;

        public B(int val, double x) {
            super(val);
            this.x = x;
        }

        @Override
        public void _func() {
            countB++;
            System.out.println("_func from B");
        }

        public void _onlyOnB() {
            System.out.println("_onlyOnB from B");
        }

        public void _onAB() {
            super._onAB();
            System.out.println("_onAB from B");
        }
    }

    public static void main(String args[]) {
        A obj1 = new A(1);
        B obj2 = new B(1, 1.1);


        obj1._func(); // _func from A
        System.out.println();

        obj1._onAB(); // _onAB from A
        System.out.println();

        obj1.thisIsPrivateA(); // from A
        System.out.println();

//        ((B) obj1)._onlyOnB(); // cannot be cast to class

//        obj1.myVal = 1;
//        obj2.myVal=1; // myVal' has private access in 'A'
        ///////////////////////////////////
        obj1 = obj2; // A <-- AB


        obj1._func(); // _func from B
        System.out.println();

        obj1._onAB(); // _onAB from B -> _onAB from A
        System.out.println();

        obj1.thisIsPrivateA(); // from A
        System.out.println();

//        (obj1)._onlyOnB();// cannot need casting;
        ((B) obj1)._onlyOnB();


        //      obj2 =obj1; // cannot AB <!-- A


    }

}
