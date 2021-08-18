package com.epam.tc.hw3;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractExercise {
    protected WebDriver webDriver;
    protected SoftAssertions softly;
    protected Properties props;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        softly = new SoftAssertions();
        props = new Properties();

        // property reading from file has to be wrapped in a try-catch IOE block to work
        try {
            FileInputStream inputStream = new FileInputStream("config.properties");
            props.load(inputStream);
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void teardownMethod() {
        webDriver.quit();
    }
}
