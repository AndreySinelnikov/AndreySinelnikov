package com.epam.tc.hw6;

import static com.epam.tc.hw4.Utils.parsePropertiesFromFile;

import com.epam.tc.hw4.AllureListener;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import com.epam.tc.hw6.driver.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ AllureListener.class })
public abstract class AbstractExercise {

    protected Properties props;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;
    protected WebDriver webDriver;

    @BeforeMethod
    public void setupMethod(ITestContext context) {
        var webDriver = WebDriverSingleton.getWebDriver();
        webDriver.manage().window().maximize();
        props = parsePropertiesFromFile("config.properties");
        actionStep = new ActionStep(webDriver, props);
        assertionStep = new AssertionStep(webDriver, props);
        context.setAttribute("webDriver", webDriver); // screenshot listener gets it via getAttribute()
    }

    @AfterMethod
    public void teardownMethod() {
        WebDriverSingleton.closeDriver();
    }

}

