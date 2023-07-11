import utils.printArray;

public class array_of_oneness_and_zeros_to_order {

    public static void main(String a[]) {

        int arr[] = {1, 0, 0, 1, 1, 0, 1, 1, 0}; // 1 | 0
        System.out.println(" " + arr.length);

        int left = 0, right = arr.length - 1;

        while (left < right) {

            while (arr[left] == 0 && left < right)
                left++;

            while (arr[right] == 1 && left < right)
                right--;

            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }


        }

        new printArray(arr);

    }
}
