package com.epam.tc.hw4.experimental;

import static com.epam.tc.hw4.Utils.parsePropertiesFromFile;

import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class BaseTest {

    protected WebDriver webDriver;
    protected Properties props;
    protected ChildActionStep actionStep;
    protected ChildAssertionStep assertionStep;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        props = parsePropertiesFromFile("config.properties"); // changed from base hw4
        actionStep = new ChildActionStep(webDriver, props);
        assertionStep = new ChildAssertionStep(webDriver, props);
    }

    @AfterMethod
    public void teardownMethod() {
        webDriver.quit();
    }
}

