import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Prime {

    public static void main(String[] args) {


        /* Enter your code here. */
        Scanner sc = new Scanner(System.in);

        int nunTests = sc.nextInt();


        for (int i = 0; i < nunTests; i++) {
            int ele = sc.nextInt();

            if (isPrime(ele))
                System.out.println(ele + " Prime");
            else
                System.out.println(ele + " Not prime");

        }

    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return false;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}



