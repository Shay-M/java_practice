public class Recursive_division {

    static int division(int a, int b) {
        if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) {
            if (a < b)
                return 0;
            else return 1 + division(a - b, b);

        } else {

            if (a > b || a == b)
                return -1;
            else return -1 + division(a - b, -b);
        }
    }

    public static void main(String a[]) {

        System.out.println("" + division(40, 4)); //10
        System.out.println("" + division(-40, 4)); //-10
        System.out.println("" + division(40, -4)); //-10
        System.out.println("" + division(-40, -4)); //-1

    }
}


