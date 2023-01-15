import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class FulfillACertainConditionTest {
    private final static double EPSILON = 0.000001d;

    private final static double[] EngineeringSeriesArray = new double[1_000_000];
    private final static double[] onlyPositiveArray = {1.8, 2, 3, 4.2};
    private final static double[] positiveAndNegativeArray = {-1, 2, 3};

    private final static Condition noCondition = (e) -> {
        return true;
    };
    private final static Condition positiveCondition = (e) -> {
        return e >= 0;
    };
    private final static Condition EvenToLongCondition = (e) -> {
        return ((long) e) % 2 == 0;
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
                .sumArrayWithCondition(
                        EngineeringSeriesArray,
                        positiveCondition);

        final double actual = Arrays.stream(EngineeringSeriesArray)
                .sum();

        Assertions.assertTrue(Math.abs(actual - sum) < EPSILON);
    }

    @Test
    void evenIfTruncatedToLongConditionSumTest() { //  2 + 4.2
        final double sum = FulfillACertainCondition
                .sumArrayWithCondition(
                        onlyPositiveArray,
                        EvenToLongCondition);

        final double actual = Arrays.stream(onlyPositiveArray)
                .filter(i -> ((long) i) % 2 == 0)
                .sum();

        Assertions.assertTrue(Math.abs(actual - sum) < EPSILON);
        // Assertions.assertEquals(6.2, sum); // not good bcz double is
    }

    @Test
    void positiveConditionMulComputationTest() {
        final double mul = FulfillACertainCondition
                .computationThatFulfilACondition(
                        positiveAndNegativeArray,
                        noCondition,
                        computationMultiple);

        Assertions.assertEquals(5, mul);
    }


}