package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractExercise {
    protected WebDriver webdriver;
    protected SoftAssertions softly;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        softly = new SoftAssertions();
    }

//    @AfterMethod
//    public void teardownMethod() {
//        webdriver.quit();
//    }
}
