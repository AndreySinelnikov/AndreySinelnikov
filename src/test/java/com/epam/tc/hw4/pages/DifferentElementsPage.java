package com.epam.tc.hw4.pages;

import com.epam.tc.hw3.components.LogDisplayComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {
    private LogDisplayComponent logDisplayComponent;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxContainer;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonsContainer;

    @FindBy(tagName = "select")
    private WebElement colorSelect;

    public DifferentElementsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
        logDisplayComponent = new LogDisplayComponent(webDriver);
    }

    public LogDisplayComponent getLogDisplayComponent() {
        return logDisplayComponent;
    }

    public List<WebElement> getCheckboxContainer() {
        return checkboxContainer;
    }

    public List<WebElement> getRadioButtonsContainer() {
        return radioButtonsContainer;
    }

    public void selectColor(String colorName) {
        Select dropdown = new Select(colorSelect);
        dropdown.selectByVisibleText(colorName);
    }
}
