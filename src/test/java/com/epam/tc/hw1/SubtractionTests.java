package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubtractionTests extends OperationTests {

    // long values: positive, negative, zero -- args and operation result within long value limits
    @DataProvider
    public static Object[][] simpleLongValuesData() {
        return new Object[][] {{100L, 50L, 50L}, {0L, 0L, 0L}, {-3L, 6L, -9L}, {-17L, -17L, 0L}};
    }

    @Test(dataProvider = "simpleLongValuesData")
    public void subSimpleLongValuesCalculated(long a, long b, long expectedResult) {
        assertThat(calculator.sub(a, b))
                .isEqualTo(expectedResult);
    }

    // double values: positive, negative, zero -- args and operation result within double value limits
    @DataProvider
    public static Object[][] simpleDoubleValuesData() {
        return new Object[][] {{100.0, 50.0, 50.0}, {0.0, 0.0, 0.0}, {23.5, -23.5, 47.0}, {-11.1, -11.2, 0.1}};
    }

    @Test(dataProvider = "simpleDoubleValuesData")
    public void subSimpleDoubleValuesCalculated(double a, double b, double expectedResult) {
        assertThat(calculator.sub(a, b))
                .isEqualTo(expectedResult);
    }

    @DataProvider
    public static Object[][] doubleValuesIncludeInfinityData() {
        return new Object[][] {{POS_INFINITY, 5.0, POS_INFINITY}, {NEG_INFINITY, -23.0, NEG_INFINITY}};
    }

    @Test(dataProvider = "doubleValuesIncludeInfinityData")
    public void subDoubleValuesIncludeInfinityCalculated(double a, double b, double expectedResult) {
        assertThat(calculator.sub(a, b))
                .isEqualTo(expectedResult);
    }

    @DataProvider
    public static Object[][] positiveInfinityFromPositiveInfinityData() {
        return new Object[][] {{POS_INFINITY, POS_INFINITY}};
    }

    @Test(dataProvider = "positiveInfinityFromPositiveInfinityData")
    public void subPositiveInfinityFromPositiveInfinityReturnsNaN(double a, double b) {
        assertThat(calculator.sub(a, b))
                .isNaN();
    }
}
