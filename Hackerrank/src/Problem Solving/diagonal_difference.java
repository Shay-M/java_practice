

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int sum = 0;
        int num = arr.size();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j)
                    sum += arr.get(i).get(j);
                if (i + j == num - 1)
                    sum -= arr.get(i).get(j);
            }

        }
        return Math.abs(sum);

    }

}

public class diagonal_difference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        Scanner bufferedWriter = new Scanner(System.in);

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        System.out.println(result);
        System.out.println(" ");

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

