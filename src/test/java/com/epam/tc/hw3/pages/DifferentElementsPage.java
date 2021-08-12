package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.LogDisplayComponent;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractPage {
    private LogDisplayComponent logDisplayComponent;

    static String url = "https://jdi-testing.github.io/jdi-light/different-elements.html"; // ref to outer

    public DifferentElementsPage(WebDriver webdriver) {
        super(webdriver, url);
        logDisplayComponent = new LogDisplayComponent();
    }
}
