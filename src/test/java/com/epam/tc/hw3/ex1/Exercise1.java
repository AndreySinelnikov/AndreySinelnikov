package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.Exercise;
import com.epam.tc.hw3.pages.HomePage;
import org.testng.annotations.Test;

public class Exercise1 extends Exercise {

    @Test
    public void exercise1() {
        HomePage home = new HomePage(webdriver);
    }
}
