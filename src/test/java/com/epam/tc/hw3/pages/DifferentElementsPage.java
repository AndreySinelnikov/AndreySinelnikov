package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.LogDisplayComponent;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends BasePage {
    private LogDisplayComponent logDisplayComponent;

    public DifferentElementsPage(WebDriver webdriver, String url) {
        super(webdriver, url);
        logDisplayComponent = new LogDisplayComponent(webdriver);
    }

    public LogDisplayComponent getLogDisplayComponent() {
        return logDisplayComponent;
    }
}
