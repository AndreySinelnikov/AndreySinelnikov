package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
//import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;

import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        openSite(JdiSite.class);
        //initSite(JDISite.class);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        // killAllSeleniumDrivers();
    }
}
