package com.epam.tc.hw4.pages;

import static com.epam.tc.hw3.Utils.clickItem;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "navbar-right")
    private WebElement loginDropdown;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(css = ".row.clerafix.benefits")
    private WebElement imageRow;

    @FindBy(css = "[src='https://jdi-testing.github.io/jdi-light/frame-button.html']")
    private List<WebElement> iframesWithFrameButton;

    public HomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public void login(String username, String password) {
        loginDropdown.click();
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getLoggedUserName() {
        return usernameLabel.getText();
    }

    public List<WebElement> getImages() {
        return imageRow.findElements(By.className("benefit-icon"));
    }

    public List<WebElement> getImageCaptions() {
        return imageRow.findElements(By.className("benefit-txt"));
    }

    public List<WebElement> getIframesWithFrameButton() {
        return iframesWithFrameButton;
    }

    public DifferentElementsPage openDifferentElementsPage(String url) {
        clickItem(getUpperNavPanel().getNavElements(), "SERVICE");
        webDriver.findElement(By.cssSelector("[href='different-elements.html']")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlMatches("https://jdi-testing.github.io/jdi-light/different-elements.html"));

        return new DifferentElementsPage(webDriver, url);
    }
}
