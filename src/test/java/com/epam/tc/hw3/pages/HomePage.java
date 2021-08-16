package com.epam.tc.hw3.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "frame")
    private List<WebElement> iframes;

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

    public List<WebElement> getImageList() {
        return imageRow.findElements(By.className("benefit-icon"));
    }

    public List<String> getImageCaptionsList() {
        return imageRow.findElements(By.className("benefit-txt")).stream()
                       .map(elem -> elem.getAttribute("innerText"))
                       .collect(Collectors.toList());
    }



}
