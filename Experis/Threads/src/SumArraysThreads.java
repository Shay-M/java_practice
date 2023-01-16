import java.security.SecureRandom;
// 1
public class SumArraysThreads {
    public static void main(final String[] args) {
        final int[] array = createRandomIntegerArray(1_000_000);

        final int sumNormal = sumArray(array);
        System.out.println("sum Normal: " + sumNormal);

        final int sumThreads = sumArrayWithTwoThreads(array);
        System.out.println("sum Threads:" + sumThreads);
     }

    private static int sumArray(final int[] array) {
        int sumArray = 0;
        // sumArray = Arrays.stream(array , 0 , array.length).parallel().sum();
        for (int num : array) {
            sumArray += num;
        }
        return sumArray;
    }

    private static int sumArrayWithTwoThreads(final int[] array) {
        return sumArrayWithTwoThreads(array, 2); // << to create default
    }

    private static int sumArrayWithTwoThreads(final int[] array, final int threads) {
        final int arrayLength = array.length;
        final int[] partial = {0, 0};

        //todo use in array of threads

        final Thread thread1 = new Thread(() -> {
            int s = 0;
            for (int i = 0; i < arrayLength / 2; i++) {
                s += array[i];
            }
            partial[0] = s;
        });

        final Thread thread2 = new Thread(() -> {
            for (int i = arrayLength / 2; i < arrayLength; i++) {
                partial[1] += array[i];
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        final int totalSum = partial[0] + partial[1];
        return totalSum;
    }

    private static int[] createRandomIntegerArray(final int arrayLength) {
        final SecureRandom secureRandom = new SecureRandom();
        final int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = secureRandom.nextInt();
        }

        return array;
    }
}

