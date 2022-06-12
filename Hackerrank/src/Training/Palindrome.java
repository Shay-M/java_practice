import java.util.Scanner;

public class Palindrome {

    public static void PalindromeNumber() {
        int r, sum = 0, temp;
        int n = 454;//It is the number variable to be checked for palindrome

        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");

    }

    public static void PalindromeString() {

        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();

        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");
    }

    public static void PalindromeString2() {

        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();

        for (int i = 0; i <= 1 + length / 2; i++)
            if (original.charAt(i) != original.charAt(length - i - 1))
                break;


    }

    public static void main(String args[]) {

//        PalindromeNumber();

        PalindromeString2();

    }
}

