package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AdditionTests extends OperationTests {

    // long values: positive, negative, zero -- args and operation result within long value limits
    @DataProvider
    public static Object[][] simpleLongValues_Data() {
        return new Object[][] {{2L, 2L, 4L}, {0L, 0L, 0L}, {-3L, -6L, -9L}, {10L, -20L, -10L}};
    }

    @Test(dataProvider = "simpleLongValues_Data")
    public void sum_simpleLongValues_Calculated(long a, long b, long expectedResult) {
        assertThat(calculator.sum(a, b))
                .isEqualTo(expectedResult);
    }

    // double values: positive, negative, zero -- args and operation result within double value limits
    @DataProvider
    public static Object[][] simpleDoubleValues_Data() {
        return new Object[][] {{2.0, 2.0, 4.0}, {0.0, 0.0, 0.0}, {0.2, -0.3, -0.1}, {-11.1, -11.1, -22.2}};
    }

    @Test(dataProvider = "simpleDoubleValues_Data")
    public void sum_simpleDoubleValues_Calculated(double a, double b, double expectedResult) {
        assertThat(calculator.sum(a, b))
                .isEqualTo(expectedResult);
    }

    @DataProvider
    public static Object[][] doubleValuesIncludeInfinity_Data() {
        return new Object[][] {{POS_INFINITY, 5.0, POS_INFINITY}, {NEG_INFINITY, -23.0, NEG_INFINITY}};
    }

    @Test(dataProvider = "doubleValuesIncludeInfinity_Data")
    public void sum_doubleValuesIncludeInfinity_Calculated(double a, double b, double expectedResult) {
        assertThat(calculator.sum(a, b))
                .isEqualTo(expectedResult);
    }

    @Test
    public void sum_positiveInfinityWithNegativeInfinity_NaN() {
        assertThat(calculator.sum(POS_INFINITY, NEG_INFINITY))
                .isNaN();
    }
}
