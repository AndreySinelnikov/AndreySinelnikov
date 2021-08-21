package com.epam.tc.hw4.steps;

import static com.epam.tc.hw4.Utils.getTextsOfElements;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.steps.AbstractStep;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver, Properties props) {
        super(webDriver, props);
    }

    @Step("Assert browser title for home page is equal to '{expectedTitle}'")
    public void homePageTitleShouldBeEqualToExpected(String expectedTitle) {
        assertThat(homePage.getTitle())
            .isEqualTo(expectedTitle);
    }

    @Step("Assert that displayed username is equal to '{expectedUser}'")
    public void displayedUserShouldBeEqualToExpected(String expectedUser) {
        assertThat(homePage.getLoggedUserName())
            .isEqualTo(expectedUser);
    }

    @Step("Assert that there are 4 items in site header, all displayed and with expected texts")
    public void headerPanelShouldHaveProperDisplayedItems(String expectedTexts) {
        List<WebElement> headerItems = homePage.getUpperNavPanel().getNavElements();
        containerShouldHaveNumberOfDisplayedItemsWithExpectedTexts(headerItems, 4, expectedTexts);
    }

    @Step("Assert that are 4 images on the home page and they are displayed")
    public void imageRowShouldHaveProperNumberOfDisplayedItems() {
        assertThat(homePage.getImages())
            .hasSize(4)
            .allMatch(WebElement::isDisplayed);
    }

    @Step("Assert that there are 4 image captions on the home page and they have expected texts")
    public void imageCaptionsShouldHaveExpectedQuantityAndTexts(String expectedTexts) {
        List<WebElement> captions = homePage.getImageCaptions();
        containerShouldHaveNumberOfDisplayedItemsWithExpectedTexts(captions, 4, expectedTexts);
    }

    @Step("Assert that there is an iframe with 'Frame Button' text")
    public void iframeWithFrameButtonShouldExist() {
        assertThat(homePage.getIframesWithFrameButton())
                      .isNotEmpty();
    }

    @Step("Assert that there is “Frame Button” in the iframe")
    public void frameButtonShouldExistInTheIframe(WebDriver webDriver) {
        List<WebElement> frameButtons = webDriver.findElements(By.id("frame-button"));
        assertThat(frameButtons)
            .isNotEmpty();
    }

    @Step("Assert that there are 5 items in left navigation panel, all displayed and with expected texts")
    public void leftNavPanelShouldHaveProperDisplayedItems(String expectedTexts) {
        List<WebElement> leftNavPanelItems = homePage.getLeftNavPanel().getNavElements();
        containerShouldHaveNumberOfDisplayedItemsWithExpectedTexts(leftNavPanelItems, 5, expectedTexts);
    }

    @Step("Assert that there are log entries corresponding to select actions")
    public void selectActionsShouldBeLogged(String expectedEntries) {
        assertThat(differentElementsPage.getLogDisplayComponent().getLogEntriesWithoutDates())
            .isEqualTo(Arrays.asList(expectedEntries.split(";")));
    }

    // utility method
    private static void containerShouldHaveNumberOfDisplayedItemsWithExpectedTexts(List<WebElement> containerItems,
                                                                            int itemNumber, String expectedTexts) {
        SoftAssertions softly = new SoftAssertions();
        List<String> expectedTextsList = Arrays.asList(expectedTexts.split(";"));
        softly.assertThat(containerItems)
              .hasSize(itemNumber)
              .allMatch(WebElement::isDisplayed);
        softly.assertThat(getTextsOfElements(containerItems))
              .isEqualTo(expectedTextsList);
        softly.assertAll();
    }
}
