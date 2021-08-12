package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractExercise;
import com.epam.tc.hw3.pages.HomePage;
import org.testng.annotations.Test;

public class Exercise1 extends AbstractExercise {

    @Test
    public void exercise1() {
        HomePage home = new HomePage(webdriver);
        home.open();
    }
}
