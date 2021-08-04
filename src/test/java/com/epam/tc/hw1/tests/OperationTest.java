package com.epam.tc.hw1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class OperationTest {
    private Calculator calculator;

    @BeforeClass
    public void setCalculator() {
        calculator = new Calculator();
    }
}
