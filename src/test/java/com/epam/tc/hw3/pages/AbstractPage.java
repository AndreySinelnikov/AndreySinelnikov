package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.LeftNavigationPanel;
import com.epam.tc.hw3.pages.components.SearchAndLoginComponent;
import com.epam.tc.hw3.pages.components.UpperNavigationPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver webdriver;
    protected UpperNavigationPanel upperNavigationPanel;
    protected LeftNavigationPanel leftNavigationPanel;
    protected SearchAndLoginComponent searchAndLoginComponent;
    protected String pageUrl;

    public AbstractPage(WebDriver webdriver, String url) {
        PageFactory.initElements(webdriver, this);
        upperNavigationPanel = new UpperNavigationPanel();
        leftNavigationPanel = new LeftNavigationPanel();
        searchAndLoginComponent = new SearchAndLoginComponent(webdriver);
        this.webdriver = webdriver;
        pageUrl = url;
    }

    public void open() {
        webdriver.navigate().to(pageUrl);
    }
}
