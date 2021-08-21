package com.epam.tc.hw4;

import static com.epam.tc.hw4.Utils.parsePropertiesFromFile;

import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ AllureListener.class })
public abstract class AbstractExercise {

    protected WebDriver webDriver;
    protected Properties props;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    public void setupClass(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        props = parsePropertiesFromFile("config.properties");
        actionStep = new ActionStep(webDriver, props);
        assertionStep = new AssertionStep(webDriver, props);
        context.setAttribute("webDriver", webDriver); // screenshot listener gets it via getAttribute()
    }

    @AfterClass
    public void teardownClass() {
        webDriver.quit();
    }
}

