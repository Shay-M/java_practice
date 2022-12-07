package Tests2022.Mgan2;

/*public class Ex4 {

    public static class A {

        public int Goo(double x) {
            return (int) x;
        }

        ////1. V
//        public int Doo(int i, double x) {
//            return 1;
//        }
//
//       // 2. X
//        public int Doo(double i) {
//            return (int) i;
//        }
//
//       // 3. V
//        public double Goo(int z) {
//            return z;
//        }
//
//       // 4. V
//        public double Doo(double i) {
//            return 2;
//        }
//
//          //5. X
//        public void Doo(double i) {
//            System.out.println("i = " + i);
//        }
//    }
    }

    public static class B extends A {
        public double Doo(double i) {
            return i;
        }

    }

    public static void main(String[] args) {
//        B b = new B();
//        //
//        A ff = new A();

//        B ab = new A(); // (1)
//        ab.Doo(44);

//        A aa = new B(); // (2)
//        aa.Goo(3);
    }

}*/

public class Ex4 {

    interface I {
        String name(String str);
    }

    public static class A implements I {

//        public A() {
//        }

        public int boy(float x) {
            return (int) x;
        }

        public String name(String str) {
            return "null";
        }
    }

    public static class B extends A {
        protected int num = 1 + 6 + 3;

        public int boy(int i) {
            return i;
        }

        //1. V
   /*    public int boy(double i) {
            return (int) i + num;
        }


//        // 2. V
        public String boy(float i, String str1) {
            return this.name(str1);
        }*/


        // 3. X
/*        public double boy(int z) {
            return z + 1;
        }*/


        // 4. V
//        public String name(String str) {
//            return "str" + str;
//        }

        // 5. V
/*        public void boy(String st) {
            B a = new B();
            a.boy(4f);
        }*/

    }

    public static void main(String[] args) {


//        A b = new B();
//        b.boy(3f);
//        ((B) b).num = 2;
//        b.boy(3);
//
       /* A a = new A();
        a.boy(3);
        ((B) a).num = 3;
        a.name("dan");
*/

    }

}
