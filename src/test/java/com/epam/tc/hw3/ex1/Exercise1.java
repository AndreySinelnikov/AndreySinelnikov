package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractExercise;
import com.epam.tc.hw3.pages.HomePage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.testng.annotations.Test;

public class Exercise1 extends AbstractExercise {

    @Test
    public void exercise1() {
        HomePage home = new HomePage(webdriver, properties.getProperty("homepage"));
        // 1. Open test site by URL
        home.open();
        // 2. Assert Browser title

        // 3. Perform login
        home.upperNavigationPanel.login(properties.getProperty("username"), properties.getProperty("password"));





    }
}
