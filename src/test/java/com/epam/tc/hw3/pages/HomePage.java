package com.epam.tc.hw3.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
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

    public HomePage(WebDriver webdriver, String url) {
        super(webdriver, url);
    }

    public void login(String username, String password) {
        loginDropdown.click();
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
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
}
