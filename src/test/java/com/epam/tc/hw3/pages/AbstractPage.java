package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.LeftNavigationPanel;
import com.epam.tc.hw3.pages.components.UpperNavigationPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver webdriver;
    public UpperNavigationPanel upperNavigationPanel;
    public LeftNavigationPanel leftNavigationPanel;
    protected String baseURL;

    public AbstractPage(WebDriver webdriver, String url) {
        PageFactory.initElements(webdriver, this);
        upperNavigationPanel = new UpperNavigationPanel(webdriver);
        leftNavigationPanel = new LeftNavigationPanel();
        this.webdriver = webdriver;
        baseURL = url;
    }

    public void open() {
        webdriver.navigate().to(baseURL);
    }
}
