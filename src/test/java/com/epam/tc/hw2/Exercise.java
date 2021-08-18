package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Exercise {
    protected WebDriver webdriver;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
    }

    @AfterMethod
    public void teardownMethod() {
        webdriver.quit();
    }
}
