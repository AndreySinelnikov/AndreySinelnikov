package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public class AbstractStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected WebDriver webDriver;

    protected AbstractStep() {
        webDriver = TestContext.getInstance().getTestObject("web_driver");
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
