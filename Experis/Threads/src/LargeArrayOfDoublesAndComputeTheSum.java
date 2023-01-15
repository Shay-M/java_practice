import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeArrayOfDoublesAndComputeTheSum {

/*
1. write a function that accepts a large array of doubles and compute the sum of all elements that fulfill a certain condition. The condition is to be passed by the caller.
[use lambdas for condition]
2. Write tests using JUnit for the above
    a. compute sum of all positive numbers.
    b. compute sum of numbers that would be even if truncated to long.
3. Add a function that accepts a large array of doubles and perform some computation on all elements that fulfil a condition. The computation and condition should be passed by the caller.
4. Write JUnit tests for the above:
    a. compute sum of all positive numbers.
    a. compute product of all none zero numbers.*/

    public static void main(final String[] args) {
        final double[] array = createRandomDoublerArray(1_000_000);

        final double sumNormal = sumArrayNormal(array);
        System.out.println("sum Normal: " + sumNormal);

        final double sumThreads = sumArrayWithThreads(array);
        System.out.println("sum Threads:" + sumThreads);
    }

    private static double sumArrayNormal(final double[] array) {
        double sumArray = 0;
        // sumArray = Arrays.stream(array, 0, array.length).parallel().sum();
        for (double num : array) {
            sumArray += num;
        }
        return sumArray;
    }

    private static double sumArrayWithThreads(final double[] array) {
        return sumArrayWithThreads(array, 2); // << to create default
    }

    private static double sumArrayWithThreads(final double[] array, final int numberOfThreads) {
        final double[] partial = new double[numberOfThreads];
        // final List<Thread> threads = new ArrayList<Thread>();
        final int arrayLength = array.length;
        final var threads = new ArrayList<Thread>();
        final int segmentSize = array.length / numberOfThreads;

        for (int j = 0; j < numberOfThreads; ++j) {
            int start = segmentSize * j;
            int end = segmentSize * (j + 1);
            if (j == numberOfThreads - 1) {
                end = arrayLength;
            }
            final int endForThread = end;
            final int threadId = j;
            threads.add(new Thread(() -> {
                double s = 0;
                for (int i = start; i < endForThread; ++i) {
                    s += array[i];
                }
                partial[threadId] = s;
            }));
        }

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        final double totalSum = Arrays.stream(partial).sum();
        return totalSum;
    }

    private static double[] createRandomDoublerArray(final int arrayLength) {
        final SecureRandom secureRandom = new SecureRandom();
        final double[] array = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = secureRandom.nextDouble();
        }

        return array;
    }
}

