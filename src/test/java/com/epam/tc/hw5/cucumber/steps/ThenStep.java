package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.cucumber.User.getUserListFromDataTable;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.cucumber.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

public class ThenStep extends AbstractStep {

    @Then("1 log row has {string} text in log section on Elements Page")
    public void assertThereIsARowWithTextInElementLogs(String text) {
        assertThat(differentElementsPage.getLogDisplayComponent().getLogEntriesWithoutDates())
            .contains(text);
    }

    @Then("1 log row has {string} text in log section")
    public void assertThereIsARowWithTextInUserLogs(String text) {
        assertThat(userTablePage.getLogDisplayComponent().getLogEntriesWithoutDates())
            .contains(text);
    }

    @Then("{string} page should be opened")
    public void assertPageIsOpened(String pageName) {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(webDriver.getTitle())
            .isEqualTo(pageName);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void typeDroplistForRomanShouldContainValues(List<String> expectedValues) {  // 1 column, auto coercion
        assertThat(expectedValues.subList(1, expectedValues.size()))  // column name got put at index 0, though
            .isEqualTo(userTablePage.getRomanSelectOptions());
    }


    @Then("User table should contain following values:")
    public void assertThatUserTableContainsValues(DataTable table) {
        List<User> expectedUsers = getUserListFromDataTable(table);
        List<User> actualUsers = userTablePage.getUsersOnPageAsList();
        assertThat(expectedUsers)
            .isEqualTo(actualUsers);
    }

    // If only Exercise2.feature steps had more quotes in them, copypasted methods below could be rolled into one with
    // "{int} {string} should be displayed on Users Table on User Table Page"

    // That's actually Type dropdowns, insufficient column width for Number just makes it seem like it's glued to Type
    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertThatNumberTypeDropdownsAreDisplayed(int expectedNumber) {
        assertThat(userTablePage.getNumberTypeDropdowns())
            .hasSize(expectedNumber)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertThatUsernamesAreDisplayed(int expectedNumber) {
        assertThat(userTablePage.getUsernames())
            .hasSize(expectedNumber)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertThatImageDescriptionsAreDisplayed(int expectedNumber) {
        assertThat(userTablePage.getImageDescriptions())
            .hasSize(expectedNumber)
            .allMatch(WebElement::isDisplayed);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertThatCheckboxesAreDisplayed(int expectedNumber) {
        assertThat(userTablePage.getCheckboxes())
            .hasSize(expectedNumber)
            .allMatch(WebElement::isDisplayed);
    }
}
