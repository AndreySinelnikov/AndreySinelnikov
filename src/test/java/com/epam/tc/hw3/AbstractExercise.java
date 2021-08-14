package com.epam.tc.hw3;


import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractExercise {
    protected WebDriver webdriver;
    protected SoftAssertions softly;
    public Properties properties;

    @BeforeMethod
    public void setupMethod() {
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        softly = new SoftAssertions();
        properties = new Properties();

        // property reading from file has to be wrapped in a try-catch block to work
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    @AfterMethod
//    public void teardownMethod() {
//        webdriver.quit();
//    }
}
