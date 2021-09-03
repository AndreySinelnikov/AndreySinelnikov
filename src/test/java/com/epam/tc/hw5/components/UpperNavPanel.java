package com.epam.tc.hw5.components;

import static com.epam.tc.hw5.Utils.getDirectChildren;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperNavPanel extends AbstractComponent {
    @FindBy(className = "m-l8")
    private WebElement navElementContainer;

    @FindBy(css = "li.dropdown:not(.uui-profile-menu)")
    private WebElement serviceButton;

    @FindBy(css = "ul.dropdown-menu[role='menu']")
    private List<WebElement> serviceDropdownItems;

    @FindBy(css = "a[href='user-table.html']")
    private WebElement userTableButton;

    @FindBy(css = "[href='different-elements.html']") //  .dropdown-menu a[href='different-elements.html']
    private WebElement diffElemButton;

    public UpperNavPanel(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getNavElements() {
        // wait.until(visibilityOfAllElements(getDirectChildren(navElementContainer)));
        return getDirectChildren(navElementContainer);
    }

    public void clickServiceButton() {
        serviceButton.click();
    }

    public void clickUserTableButton() {
        wait.until(elementToBeClickable(userTableButton)).click();
    }

    public void clickDifferentElementsButton() {
        wait.until(elementToBeClickable(diffElemButton)).click();
    }
}
