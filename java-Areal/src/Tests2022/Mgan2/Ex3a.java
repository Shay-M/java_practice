package Tests2022.Mgan2;

public class Ex3a {
/*    public static void main(String[] args) {

        B b1 = new A(); // A extends B
        B b2 = new C(); // C extends B
        A a1 = (C) b2; // >> C extends A יש השמה
        D d1 = new C(); // C extends D
        B b3 = new B();
        D d2 = new A(); // A extends D
    }

   *//* private static class B extends D {
    }

    private static class C extends A {
    }

    private static class A extends B {
    }

    private static class D {
    }*//*
//////XXXX
    private static class B  {
    }

    private static class C extends D {
    }

    private static class A extends B {
    }

    private static class D extends A{
    }
}*/
////XXX

//    Dod b1 = new Lol();
//    Dod b2 = new Foo();
//    Lol a1 = (Foo) b2;
//    Lol a2 = new Lol();
//    Bob d1 = new Foo();
//   Bob d2 = new Lol();

    public static void main(String[] args) {

        Bob a0 = new Bob();
        Dod a1 = new Lol();
        Dod a2 = new Foo();
        Lol a3 = (Foo) a2;
        Lol a4 = new Lol();
        Bob a5 = new Foo();

        Bob a6 = new Lol();

    }

    private static class Dod extends Bob {
    }

    private static class Foo extends Lol {
    }

    private static class Lol extends Dod {
    }

    private static class Bob {
    }

//    Bob a6 = new Lol(); //X

    /*private static class Dod {
    }

    private static class Foo extends Bob {
    }

    private static class Lol extends Dod {
    }

    private static class Bob extends Lol{
    }*/
}





