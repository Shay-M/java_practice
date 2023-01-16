import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class FulfillACertainCondition {

/*
1. write a function that accepts a large array of doubles and compute the sum of all
 elements that fulfill a certain condition. The condition is to be passed by the caller.
[use lambdas for condition]
2. Write tests using JUnit for the above
    a. compute sum of all positive numbers.
    b. compute sum of numbers that would be even if truncated to long.
3. Add a function that accepts a large array of doubles and perform some computation on all elements that fulfil a condition. The computation and condition should be passed by the caller.
4. Write JUnit tests for the above:
    a. compute sum of all positive numbers.
    a. compute product of all none zero numbers.*/

    public static void main(final String[] args) {
    }

    public static double[] createRandomDoublerArray(final int arrayLength) {
        final SecureRandom secureRandom = new SecureRandom();
        final double[] array = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = secureRandom.nextDouble();
        }

        return array;
    }

    public static double sumArrayWithCondition(final double[] array, final Predicate<Double> condition) {
        final double sumArray = Arrays.stream(array, 0, array.length)
                .parallel()
                .filter((num) -> condition.test(num))
                .sum();

        return sumArray;
    }

    public static double sumArrayWithConditionWithThreads(final double[] array, final Predicate<Double> condition) {
        return sumArrayWithConditionWithThreads(array, condition, 2); // << to create default
    }

    public static double sumArrayWithConditionWithThreads(final double[] array, final Predicate<Double> condition, final int numberOfThreads) {
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
                double sumFromPartials = 0;
                for (int i = start; i < endForThread; ++i) { // was: if (condition.check(array[i])) {
                    if (condition.test(array[i])) {
                        sumFromPartials += array[i];
                    }
                }
                partial[threadId] = sumFromPartials;
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

    public static double computationThatFulfilACondition(final double[] array, final Predicate<Double> condition, final Computation computation) {
        double s = 0;
        for (double num : array) {
            if (condition.test(num)) {
                s = computation.computation(num, s);
            }
        }

        return s;
    }

    public static double computationConditionWithThreads(final double[] array, final Predicate<Double> condition, final Computation computation) {
        return computationConditionWithThreads(array, condition, computation, 2);
    }

    public static double computationConditionWithThreads(final double[] array, final Predicate<Double> condition, final Computation computation, final int numberOfThreads) {
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
                double computationResult = 0;
                for (int i = start; i < endForThread; ++i) {
                    if (condition.test(array[i])) {
                        computationResult = computation.computation(array[i], computationResult);
                    }
                }
                partial[threadId] = computationResult;
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
}

//https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/function/package-summary.html