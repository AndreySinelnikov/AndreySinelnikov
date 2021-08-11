package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivisionTests extends OperationTests {

    // long values: positive, negative -- args and operation result within long value limits, no truncation
    @DataProvider
    public static Object[][] simpleLongValuesData() {
        return new Object[][] {{4L, 2L, 2L}, {18L, -3L, -6L}, {-10L, -5L, 2L}};
    }

    @Test(dataProvider = "simpleLongValuesData")
    public void divSimpleLongValuesCalculated(long a, long b, long expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    // long values: positive, negative -- args and operation result within long value limits, result truncated
    @DataProvider
    public static Object[][] longValuesProducingTruncatedResultData() {
        return new Object[][] {{3L, 6L, 0L}, {10L, 3L, 3L}, {-5L, 2L, -2L}};
    }

    @Test(dataProvider = "longValuesProducingTruncatedResultData")
    public void divLongValuesProducingTruncatedResultCalculated(long a, long b, long expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    // double values: positive, negative -- args and operation result within double value limits
    @DataProvider
    public static Object[][] simpleDoubleValuesData() {
        return new Object[][] {{9.0, 3.0, 3.0}, {-5.0, 2.0, -2.5}, {1.0, 3.0, 0.3333333333333333}};
    }

    @Test(dataProvider = "simpleDoubleValuesData")
    public void divSimpleDoubleValuesCalculated(double a, double b, double expectedResult) {
        assertThat(calculator.div(a, b))
                .isEqualTo(expectedResult);
    }

    @DataProvider
    public static Object[][] longValueByZeroData() {
        return new Object[][] {{1L, 0L}};
    }

    @Test(dataProvider = "longValueByZeroData", expectedExceptions = { NumberFormatException.class })
    public void divLongValueByZeroThrowsNumberFormatException(long a, long b) {
        calculator.div(a, b);
    }

    @DataProvider
    public static Object[][] doubleZeroValueByDoubleZeroValueData() {
        return new Object[][] {{0.0, 0.0}};
    }

    @Test(dataProvider = "doubleZeroValueByDoubleZeroValueData")
    public void divDoubleZeroValueByDoubleZeroValueReturnsNaN(double a, double b) {
        assertThat(calculator.div(a, b))
                .isNaN();
    }

    @DataProvider
    public static Object[][] doubleNonZeroValueByDoubleZeroValueData() {
        return new Object[][] {{1.0, 0.0}};
    }

    @Test(dataProvider = "doubleNonZeroValueByDoubleZeroValueData")
    public void divDoubleNonZeroValueByDoubleZeroValueReturnsPositiveInfinity(double a, double b) {
        assertThat(calculator.div(a, b))
                .isEqualTo(POS_INFINITY);
    }
}
