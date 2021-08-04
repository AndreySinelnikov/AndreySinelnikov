package com.epam.tc.hw1.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AdditionTest extends OperationTest {

    @DataProvider
    public static Object[][] simpleLongValues_Data() {
        return new Object[][] {{2L, 2L, 4L}, {0L, 1000L, 1000L}, {-3L, -6L, -9L}, {10L, -20L, -10L}};
    }

    @Test(dataProvider = "simpleLongValues_Data")
    public void sum_simpleLongValues_Calculated(long a, long b, long expectedResult) {
        assertThat(calculator.sum(a, b))
                .isEqualTo(expectedResult);
    }

    @Test
    public void alwaysPassedAdditionTest() {
        assertThat(true);
    }
}
