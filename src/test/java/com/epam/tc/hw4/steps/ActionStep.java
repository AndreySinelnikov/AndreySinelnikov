package com.epam.tc.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {


    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open test site by URL")
    public void openHomePage() {
        homePage.open();
    }
}
