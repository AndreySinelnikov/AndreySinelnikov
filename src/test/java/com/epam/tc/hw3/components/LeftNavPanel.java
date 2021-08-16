package com.epam.tc.hw3.components;

import static com.epam.tc.hw3.Utils.getDirectChildren;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavPanel extends BaseComponent {
    @FindBy(css = ".sidebar-menu.left")
    private WebElement navElementContainer;

    public LeftNavPanel(WebDriver webdriver) {
        super(webdriver);
    }

    public List<WebElement> getNavElements() {
        return getDirectChildren(navElementContainer);
    }

}
