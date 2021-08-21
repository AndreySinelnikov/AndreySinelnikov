package com.epam.tc.hw4.steps;


import com.epam.tc.hw4.steps.AbstractStep;
import io.qameta.allure.Step;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver, Properties props) {
        super(webDriver, props);
    }

    @Step("Open home page by URL")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Perform login with username '{username}' and password '{password}'")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @Step("Switch to iFrame with 'Frame Button'")
    public void switchToIframeWithFrameButton(WebDriver webDriver) {
        webDriver.switchTo().frame(homePage.getIframesWithFrameButton().get(0));
    }

    @Step("Switch back from iFrame to parent frame")
    public void switchFromIframeToParentFrame(WebDriver webDriver) {
        webDriver.switchTo().parentFrame();
    }
}
