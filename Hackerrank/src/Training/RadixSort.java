import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RadixSort {

    // function to print array elements
    static void printArray(int a[], int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }

    int getMax(int a[], int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max; //maximum element from the array
    }

    void countingSort(int a[], int n, int place) // function to implement counting sort

    {
        int[] output = new int[n + 1];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < n; i++)
            count[(a[i] / place) % 10]++;

        // Calculate cumulative frequency
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(a[i] / place) % 10] - 1] = a[i];
            count[(a[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++)
            a[i] = output[i];
    }


    // function to implement radix sort
    void radixsort(int a[], int n) {

        // get maximum element from array
        int max = getMax(a, n);

        // Apply counting sort to sort elements based on place value
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(a, n, place);
    }


    public static void main(String a[]) {
        String str1 = "shalom";
        String str2 = "shalmn";

        char[] ArrayOfChar1 = str1.toCharArray();
        char[] ArrayOfChar2 = str2.toCharArray();

        if (ArrayOfChar1.length != ArrayOfChar2.length)
            System.out.println("no!");

        int[] num1 = new int[ArrayOfChar1.length];
        int[] num2 = new int[ArrayOfChar1.length];

        for (int i = 0; i < ArrayOfChar1.length; i++) {

            num1[i] = ArrayOfChar1[i] - '0';
            num2[i] = ArrayOfChar2[i] - '0';

        }

        int n = ArrayOfChar1.length;
        RadixSort r1 = new RadixSort();
        r1.radixsort(num1, n);
        r1.radixsort(num2, n);

        printArray(num1, n);
        printArray(num2, n);

        if (Arrays.equals(num1, num2))
            System.out.print("YES!");
        else System.out.print("NO!");


    }


}
