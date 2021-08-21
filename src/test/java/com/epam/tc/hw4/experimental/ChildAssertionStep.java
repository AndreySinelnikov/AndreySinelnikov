package com.epam.tc.hw4.experimental;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class ChildAssertionStep extends BaseStep {

    public ChildAssertionStep(WebDriver webDriver, Properties props) {
        super(webDriver, props);
    }

    @Step("Assert browser title for home page is equal to '{expectedTitle}'")
    public void homePageTitleShouldBeEqualToExpected(String expectedTitle) {
        assertThat(homePage.getTitle())
            .isEqualTo(expectedTitle);
    }
}
