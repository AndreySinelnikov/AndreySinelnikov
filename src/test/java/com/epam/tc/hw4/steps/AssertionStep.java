package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert browser title is equal to expected")
    public void browserTitleShouldBeEqualToExpected(String expectedTitle) {
        assertThat(homePage.getTitle())
            .isEqualTo(expectedTitle);
    }
}
