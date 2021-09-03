package com.epam.tc.hw5.components;

import static com.epam.tc.hw5.Utils.getDirectChildren;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavPanel extends AbstractComponent {
    @FindBy(css = ".sidebar-menu.left")
    private WebElement navElementContainer;

    public LeftNavPanel(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getNavElements() {
        return getDirectChildren(navElementContainer);
    }

}
