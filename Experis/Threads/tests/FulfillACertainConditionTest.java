import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

class FulfillACertainConditionTest {
    private final static double EPSILON = 0.000001d;

    private final static double[] EngineeringSeriesArray = new double[1_000_000];
    private final static double[] onlyPositiveArray = {1.8, 2, 3, 4.2, 0};
    private final static double[] positiveAndNegativeArray = {-1, 2, 3};

    private final static Predicate<Double> noCondition = (e) -> {
        return true;
    };
    private final static Predicate<Double> positiveCondition = (e) -> {
        return e >= 0;
    };
    private final static Predicate<Double> evenToLongCondition = (e) -> {
        return ((long) e.doubleValue()) % 2 == 0; // doubleValue to convert to primitive double value.
    };
    private final static Predicate<Double> noneZeroNumbersCondition = (e) -> {
        return e != 0;
    };

    private final static Computation computationMultiple = (n1, mulSum) -> {
        if (mulSum == 0) {
            mulSum = 1.0;
        }
        return (n1 * mulSum);
    };

    @BeforeAll
    static void initializeArrays() {
        for (int i = 1; i < 1_000_000; ++i) {
            EngineeringSeriesArray[i - 1] = i * 3;
        }
    }

    @Test
    void positiveConditionSumTest() {
        final double sum = FulfillACertainCondition
                .sumArrayWithConditionWithThreads(
                        EngineeringSeriesArray,
                        positiveCondition);

        final double actual = Arrays.stream(EngineeringSeriesArray)
                .sum();

        Assertions.assertTrue(Math.abs(actual - sum) < EPSILON);
    }

    @Test
    void evenIfTruncatedToLongConditionSumTest() { //  2 + 4.2
        final double sum = FulfillACertainCondition
                .sumArrayWithConditionWithThreads(
                        onlyPositiveArray,
                        evenToLongCondition);

        final double actual = Arrays.stream(onlyPositiveArray)
                .filter(i -> ((long) i) % 2 == 0)
                .sum();

        Assertions.assertTrue(Math.abs(actual - sum) < EPSILON);
        // Assertions.assertEquals(6.2, sum); // not good bcz double is
    }

    @Test
    void positiveConditionMulComputationTest() {
        final double mul = FulfillACertainCondition
                .computationThatFulfilAConditionWithThreads(
                        positiveAndNegativeArray,
                        noCondition,
                        computationMultiple);

        Assertions.assertEquals(5, mul, EPSILON);


    }

    @Test
    void mulComputationZeroNumbersConditionTest() {
        final double mul = FulfillACertainCondition
                .computationThatFulfilAConditionWithThreads(
                        onlyPositiveArray,
                        noneZeroNumbersCondition,
                        computationMultiple);

        final double actual = Arrays.stream(onlyPositiveArray)
                .filter(i -> ((long) i) % 2 == 0)
                .sum();

        Assertions.assertEquals(5, mul, EPSILON);


    }


}