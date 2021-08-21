package com.epam.tc.hw4.experimental;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class ChildActionStep extends BaseStep {

    public ChildActionStep(WebDriver webDriver, Properties props) {
        super(webDriver, props);
    }

    @Step("Open home page by URL")
    public void openHomePage() {
        homePage.open();
    }
}
