package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivisionTests extends OperationTests {

    // long values: positive, negative -- args and operation result within long value limits, no truncation
    @DataProvider
    public static Object[][] simpleLongValues_Data() {
        return new Object[][] {{4L, 2L, 2L}, {18L, -3L, -6L}, {-10L, -5L, 2L}};
    }

    @Test(dataProvider = "simpleLongValues_Data")
    public void div_simpleLongValues_Calculated(long a, long b, long expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    // long values: positive, negative -- args and operation result within long value limits, result truncated
    @DataProvider
    public static Object[][] longValuesProducingTruncatedResult_Data() {
        return new Object[][] {{3L, 6L, 0L}, {10L, 3L, 3L}, {-5L, 2L, -2L}};
    }

    @Test(dataProvider = "longValuesProducingTruncatedResult_Data")
    public void div_longValuesProducingTruncatedResult_Calculated(long a, long b, long expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    // double values: positive, negative -- args and operation result within double value limits
    @DataProvider
    public static Object[][] simpleDoubleValues_Data() {
        return new Object[][] {{9.0, 3.0, 3.0}, {-5.0, 2.0, -2.5}, {1.0, 3.0, 0.3333333333333333}};
    }

    @Test(dataProvider = "simpleDoubleValues_Data")
    public void div_simpleDoubleValues_Calculated(double a, double b, double expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    @Test(expectedExceptions = { NumberFormatException.class })
    public void div_LongValueByZero_NumberFormatExceptionThrown() {
        calculator.div(1L, 0L);
    }

    @Test
    public void div_doubleZeroValueByDoubleZeroValue_NaN() {
        assertThat(calculator.div(0.0, 0.0))
                .isNaN();
    }

    @Test
    public void div_doubleNonZeroValueByDoubleZeroValue_PositiveInfinity() {
        assertThat(calculator.div(1.0, 0.0))
                .isEqualTo(POS_INFINITY);
    }
}
