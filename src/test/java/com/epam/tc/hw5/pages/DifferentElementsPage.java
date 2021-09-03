package com.epam.tc.hw5.pages;

import static com.epam.tc.hw5.Utils.clickItem;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw3.components.LogDisplayComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {
    private static final String url = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    private LogDisplayComponent logDisplayComponent;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxContainer;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonsContainer;

    @FindBy(tagName = "select")
    private WebElement colorSelect;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver, url);
        logDisplayComponent = new LogDisplayComponent(webDriver);
    }

    public LogDisplayComponent getLogDisplayComponent() {
        return logDisplayComponent;
    }

    public List<WebElement> getCheckboxContainer() {
        wait.until(visibilityOfAllElements(checkboxContainer));
        return checkboxContainer;
    }

    public List<WebElement> getRadioButtonsContainer() {
        wait.until(visibilityOfAllElements(radioButtonsContainer));
        return radioButtonsContainer;
    }

    public void selectColor(String colorName) {
        Select dropdown = new Select(colorSelect);
        dropdown.selectByVisibleText(colorName);
    }
}
