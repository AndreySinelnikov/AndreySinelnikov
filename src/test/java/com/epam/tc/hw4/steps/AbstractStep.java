package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected AbstractStep(WebDriver webDriver) {
        homePage = new HomePage(webDriver, "https://jdi-testing.github.io/jdi-light/index.html");
        differentElementsPage = new DifferentElementsPage(webDriver, "https://jdi-testing.github.io/jdi-light/different-elements.html");
    }
}
