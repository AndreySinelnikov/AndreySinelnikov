package com.epam.tc.hw4;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver webDriver = (WebDriver) result.getTestContext().getAttribute("webDriver");
        attachScreenshot(webDriver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(WebDriver webDriver) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
