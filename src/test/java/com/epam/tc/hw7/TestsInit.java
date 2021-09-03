package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.site.JdiSite.homePage;

import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {
    @BeforeMethod
    static void setUp() {
        killAllSeleniumDrivers();
        openSite(JdiSite.class);
    }

    @AfterMethod
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
