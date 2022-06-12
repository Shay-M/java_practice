import jdk.jshell.execution.Util;
import utils.printArray;

import java.util.List;

class Frequencys {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 8, 3, 2, 2, 2, 5, 1};
        int max = 0;

        // find the larger number
        for (int j : arr) {
            if (max < j)
                max = j;
        }

        int[] countArr = new int[max + 1];


        for (int j : arr) {
            countArr[j]++;
        }
        new printArray(arr);
        System.out.println(" ");
        new printArray(countArr);
    }
}
