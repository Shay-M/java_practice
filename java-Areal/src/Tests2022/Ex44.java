package Tests2022;

public class Ex44 {

    public static class A {
        public int Foo(int i) {
            return i;
        }

    }

    public int Foo() {
        return 1;
    }

//    public int Foo(double i) {
//        return (int) i;
//    }
//
//    public double Foo(int i) {
//        return i;
//    }
////
//    public double Foo(double i) {
//        return i;
//    }
////
//    public void Foo(double i) {
//        //Console.Write(i);
//    }

    public static void main(String[] args) {
        A a = new A();
    }
}
