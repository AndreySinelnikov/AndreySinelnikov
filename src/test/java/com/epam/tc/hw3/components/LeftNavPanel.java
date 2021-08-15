package com.epam.tc.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeftNavPanel extends AbstractComponent {

    public LeftNavPanel(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver, this);
    }
}
