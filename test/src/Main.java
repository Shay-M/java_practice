import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
//        System.out.println(" " + balance("111000"));
       /* int[] a = {2, 4};
        System.out.println(" " + minRemoval(a));*/
        System.out.println(" " + betweenTwoEqualCharacters("badfgbnm"));
    }

    /*public static Integer balance(String s) {
        final int sizeOfString = s.length();
        int count = 0;

        for (int p0 = 0; p0 < sizeOfString; ++p0) {
            if (s.charAt(p0) == '0') {
                for (int p1 = p0 + 1; p1 < sizeOfString; ++p1) {
                    if (s.charAt(p1) == '1') {
                        ++count;
                    }
                }
            } else count = 0;

        }


        return count;
    }*/
//    {2, 4, 3, 6, 8 , 1 , 3};
    public static Integer minRemoval(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] % 2 == a[i] % 2 ) {
                ++i;

            } else ++count;
        }

        return count;

    }

    public static Integer betweenTwoEqualCharacters(String s){
            int start = 0;
            int end = 0;

        return null;

    }
}