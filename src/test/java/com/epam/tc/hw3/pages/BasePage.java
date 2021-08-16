package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.LeftNavPanel;
import com.epam.tc.hw3.components.UpperNavPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webdriver;
    protected UpperNavPanel upperNavPanel;
    protected LeftNavPanel leftNavPanel;
    protected String baseURL;

    public BasePage(WebDriver webdriver, String url) {
        PageFactory.initElements(webdriver, this);  // allows FindBy for page elements
        upperNavPanel = new UpperNavPanel(webdriver);
        leftNavPanel = new LeftNavPanel(webdriver);
        this.webdriver = webdriver;
        baseURL = url;
    }

    public void load() {
        webdriver.navigate().to(baseURL);
    }

    public UpperNavPanel getUpperNavPanel() {
        return upperNavPanel;
    }

    public LeftNavPanel getLeftNavPanel() {
        return leftNavPanel;
    }

}
