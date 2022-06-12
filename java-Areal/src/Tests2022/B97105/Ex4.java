package Tests2022.B97105;

public class Ex4 {
    public static class A {
        public static int count = 0;
        private int num;

        public A() {
            count++;
            num = count;
        }

        public A(int n) {
            num = n;
        }

        public String toString() {
            return count + ", " + num;
        } // end of A
    }

    public static class B extends A {
        private String str;

        public B() {
            str = "GOOD";
        }

        public B(String s) {
            super(10);
            str = s;
        }

        public String toString() {
            return super.toString() + " " + str;

        }// end of B
    }

    public static class C extends B {
        // public static class C extends A {
        /*
        4, 10 Morning
        4, 1
        4, 2 GOOD
        4, 10 Evening
        4, 3 Night
        4, 4
       */
//    public static class C {
        /*

    **  Error: can't insert to A array C class (c not extends from A)
	Exception in thread "main" java.lang.Error: Unresolved compilation problems:
	Type mismatch: cannot convert from Ex4.C to Ex4.A
	Type mismatch: cannot convert from Ex4.C to Ex4.A
	Type mismatch: cannot convert from Ex4.C to Ex4.A
        */

        private String str;

        public C(String s) {
            str = s;
        }

        public String toString() {
            return super.toString() + " " + str;
        }// end of C

    }

//    public class Driver {

    public static void main(String[] args) {
        A[] arr = new A[6];

        arr[0] = new B("Morning"); // (1)
        arr[1] = new A(); // (2)
        arr[2] = new C("Afternoon"); // (3)
        arr[3] = new B("Evening"); // (4)
        arr[4] = new C("Night"); // (5)
        arr[5] = new C(""); // (6)

        for (A a : arr) System.out.println(a);

    }
}