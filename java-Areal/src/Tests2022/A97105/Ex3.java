package Tests2022.A97105;


import java.util.function.Function;

public class Ex3 { //3 alf!

    public static class A {
        protected int pro = 100;

    }

    public static class B extends A {
        public B(int x, String s) {
            B h = this;
            int n = 1;

            Function d = new Function() {
                @Override
                public Object apply(Object o) {
                    System.out.println("Hii from d!");
                    return null;
                }
            };

            h.g(n, d);
        }

        protected int g(int x, Function f) {
            f.apply(this);

            return 11;
        }

    }


    public static void main(String args[]) {
        int t = 3;
        String s = "hi";

        A x = new B(t, s);

        B h = new B(1, "");
        h.pro = 4;

        ///
        int n = 3;

//        Function d = new Function() {
//            @Override
//            public Object apply(Object o) {
//                System.out.println("Hii from d!");
//                return null;
//            }
//        };
//


//        h.g(n, d);


    }

}
