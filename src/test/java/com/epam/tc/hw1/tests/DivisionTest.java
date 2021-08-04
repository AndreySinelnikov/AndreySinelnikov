package com.epam.tc.hw1.tests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class DivisionTest extends OperationTest {

    @Test
    public void alwaysPassedDivisionTest() {
        assertThat(true);
    }

    @Test(expectedExceptions = { NumberFormatException.class })
    public void div_LongByZero_NumberFormatExceptionThrown() {
        calculator.div(1L, 0L);
    }
}
