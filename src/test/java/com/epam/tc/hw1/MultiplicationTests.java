package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MultiplicationTests extends OperationTests {

    // long values: positive, negative, zero -- args and operation result within long value limits
    @DataProvider
    public static Object[][] simpleLongValuesData() {
        return new Object[][] {{2L, 2L, 4L}, {0L, 0L, 0L}, {-3L, -6L, 18L}, {10L, -20L, -200L}};
    }

    @Test(dataProvider = "simpleLongValuesData")
    public void multSimpleLongValuesCalculated(long a, long b, long expectedResult) {
        assertThat(calculator.mult(a, b))
                .isEqualTo(expectedResult);
    }

    // double values: positive, negative, zero -- args and operation result within double value limits
    @DataProvider
    public static Object[][] simpleDoubleValuesData() {
        return new Object[][] {{2.0, 2.0, 4.0}, {0.0, 0.0, 0.0}, {0.2, -0.3, Math.floor(-0.6)}};
    }

    @Test(dataProvider = "simpleDoubleValuesData")
    public void multSimpleDoubleValuesCalculated(double a, double b, double expectedResult) {
        assertThat(calculator.mult(a, b))
                .isEqualTo(expectedResult);
    }

    @DataProvider
    public static Object[][] doubleValuesIncludeInfinityData() {
        return new Object[][] {{POS_INFINITY, 5.5, POS_INFINITY}, {NEG_INFINITY, -23.0, POS_INFINITY}};
    }

    @Test(dataProvider = "doubleValuesIncludeInfinityData")
    public void multDoubleValuesIncludeInfinityCalculated(double a, double b, double expectedResult) {
        assertThat(calculator.mult(a, b))
                .isEqualTo(expectedResult);
    }
}
