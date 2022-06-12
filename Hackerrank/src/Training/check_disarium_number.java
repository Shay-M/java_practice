import java.util.Scanner;

public class check_disarium_number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int sum = 0, digits, digitsCal = 0;
        int numDigits = String.valueOf(num).length();

        String printString = "";



        while (num > 0) {
            digits = num % 10;
            // Math.pow()

            for (int i = 0; i < numDigits; i++) {
                digitsCal += digits;
            }
            sum += digitsCal;
            digitsCal = 0;

            printString = digits + "^" + numDigits + printString;

            numDigits--;
            if (numDigits > 0)
                printString = " + " + printString;
            else
                printString += " = " + sum;

            num = num / 10;

        }

        System.out.println(printString);


    }
}
