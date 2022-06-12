
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import Sorts.QuickSort;

class Result3 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        QuickSort qs = new QuickSort();

        Integer[] arr2 = new Integer[arr.size()];

//        qs.quickSort(arr2,0,arr.size());
        System.out.println(arr);

//        qs.printArray();
//        for (int num : arr){
//
//        }

    }

}

public class mini_max_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result3.miniMaxSum(arr);

        bufferedReader.close();
    }
}
