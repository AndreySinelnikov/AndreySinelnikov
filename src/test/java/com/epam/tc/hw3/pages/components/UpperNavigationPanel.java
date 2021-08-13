package com.epam.tc.hw3.pages.components;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpperNavigationPanel extends AbstractComponent {
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

    public UpperNavigationPanel(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver, this);
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
}
