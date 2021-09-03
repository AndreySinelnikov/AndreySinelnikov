package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.AbstractComponent;
import com.epam.tc.hw5.components.LeftNavPanel;
import com.epam.tc.hw5.components.UpperNavPanel;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractComponent {
    protected UpperNavPanel upperNavPanel;
    protected LeftNavPanel leftNavPanel;
    protected String baseURL;

    protected AbstractPage(WebDriver webDriver, String url) {
        super(webDriver);
        upperNavPanel = new UpperNavPanel(webDriver);
        leftNavPanel = new LeftNavPanel(webDriver);
        baseURL = url;
    }

    public void open() {
        webDriver.navigate().to(baseURL);
    }

    public UpperNavPanel getUpperNavPanel() {
        return upperNavPanel;
    }

    public LeftNavPanel getLeftNavPanel() {
        return leftNavPanel;
    }
}
