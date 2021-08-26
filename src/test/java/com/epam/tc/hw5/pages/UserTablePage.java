package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.LogDisplayComponent;
import com.epam.tc.hw5.cucumber.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {
    private static final String url = "https://jdi-testing.github.io/jdi-light/user-table.html";
    private LogDisplayComponent logDisplayComponent;

    @FindBy(id = "user-table")
    private List<WebElement> userTable;

    @FindBy(className = "user-descr")
    private List<WebElement> imageDescriptions;

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr input")
    private List<WebElement> checkboxes;

    @FindBy(id = "ivan")
    private WebElement sergeyIvanCheckbox;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/select/*")
    private List<WebElement> romanSelectOptions;

    @FindBy(css = "tbody tr")
    private List<WebElement> tableRows;


    public UserTablePage(WebDriver webDriver) {
        super(webDriver, url);
        logDisplayComponent = new LogDisplayComponent(webDriver);
    }

    public LogDisplayComponent getLogDisplayComponent() {
        return logDisplayComponent;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getImageDescriptions() {
        return imageDescriptions;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public void clickVipForSergeyIvan() {
        sergeyIvanCheckbox.click();
    }

    public List<String> getRomanSelectOptions() {
        return romanSelectOptions.stream()
                            .map(option -> option.getText())
                            .collect(Collectors.toList());
    }

    public List<User> getUsersOnPageAsList() {
        List<User> userList = new ArrayList<>();
        for (WebElement elem : tableRows) {
            String number = elem.findElement(By.tagName("td")).getText();
            String name = elem.findElement(By.tagName("a")).getText();
            String description = elem.findElement(By.tagName("span")).getText();
            userList.add(new User(number, name, description));
        }
        return userList;
    }
}
