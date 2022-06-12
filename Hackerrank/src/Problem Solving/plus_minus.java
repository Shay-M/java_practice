
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result2 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int countPositive = 0;
        int countNegative = 0;
        int countZeros = 0;

        for (int num : arr) {

            //  var countOfPositive = (int) arr.stream().filter(i -> i > 0).count();
            if (num > 0)
                countPositive++;
            else if (num < 0)
                countNegative++;
            else
                countZeros++;
        }

        System.out.printf("%.6f%n", (float) countPositive / arr.size());
        System.out.printf("%.6f%n", (float) countNegative / arr.size());
        System.out.printf("%.6f%n", (float) countZeros / arr.size());
//        new String('#', i + 1);
    }

}

public class plus_minus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result2.plusMinus(arr);

        bufferedReader.close();
    }
}

