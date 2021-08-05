package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class OperationTests {
    static protected final double POS_INFINITY = Double.POSITIVE_INFINITY;
    static protected final double NEG_INFINITY = Double.NEGATIVE_INFINITY;
    protected Calculator calculator;

    @BeforeClass
    public void setCalculator() {
        calculator = new Calculator();
    }
}
