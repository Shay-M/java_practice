import java.util.Scanner;

class SingleArray {
    public static void main(String args[]) {

        System.out.println("Enter the length in the array: ");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] numbers = new int[len];
        System.out.println("Enter the elements in the array: ");
        // int n = s.nextInt();
        for (int i = 0; i < len; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("The elements in the array are: ");
        for (int i = 0; i < len; i++) {
            System.out.print(numbers[i] + " ");
        }
        //System.out.println();
        System.out.println("The sum of elements in the array are: ");
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + numbers[i];
        }
        System.out.println("Sum of elements = " + sum);
    }
}