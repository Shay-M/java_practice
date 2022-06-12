import Sorts.MergeSort;//XXX

public class pair_of_numbers_in_an_array_with_the_same_sum {

    public static void main(String a[]) {

        int arr[] = {1, 8, 3, 5, 4, 2, 2};

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        ob.printArray(arr);

        int firstNumber = arr[0];
        int secendNumber = arr[1];
        int sum = firstNumber + secendNumber;

        for (int i = 0, j = 1; i < arr.length; i++) {

            for (j = i + 1; j < arr.length; j++) {
                if (i != j) {
                    sum = arr[i] + arr[j];
                    System.out.println(" " + arr[i] + " + " + arr[j] + " = " + sum);

                    // findSumInArraay(sum, arr);
                }
            }

        }


    }

    private static void findSumInArraay(int sum, int[] arr) {


    }
}


