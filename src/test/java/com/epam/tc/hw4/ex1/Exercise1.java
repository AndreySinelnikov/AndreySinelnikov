package com.epam.tc.hw4.ex1;


import com.epam.tc.hw4.AbstractExercise;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise1 extends AbstractExercise {

    @Test
    @Feature("Homework 4")
    @Story("Exercise 1")
    public void exercise1() {
        // 1. Open test site by URL
        actionStep.openHomePage();
        // 2. Assert Browser title
        assertionStep.homePageTitleShouldBeEqualToExpected(props.getProperty("expected_homepage_title"));
        // 3. Perform login
        actionStep.login(props.getProperty("username"), props.getProperty("password"));
        // 4. Assert Username is loggined
        assertionStep.displayedUserShouldBeEqualToExpected(props.getProperty("expected_user"));
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.headerPanelShouldHaveProperDisplayedItems(props.getProperty("ex1_upper_items"));
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.imageRowShouldHaveProperNumberOfDisplayedItems();
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.imageCaptionsShouldHaveExpectedQuantityAndTexts(props.getProperty("expected_caption_texts"));
        // 8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.iframeWithFrameButtonShouldExist();
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframeWithFrameButton(webDriver);
        assertionStep.frameButtonShouldExistInTheIframe(webDriver);
        // 10. Switch to original window back
        actionStep.switchFromIframeToParentFrame(webDriver);
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.leftNavPanelShouldHaveProperDisplayedItems(props.getProperty("ex1_left_items"));
        // 12. Close Browser
        //        // handled by @AfterMethod
    }
}
//    @Test
//    public void exercise1() {
//        HomePage home = new HomePage(webDriver, props.getProperty("homepage"));
//        // 1. Open test site by URL
//        home.open();
//        // 2. Assert Browser title
//        softly.assertThat(webDriver.getTitle())
//              .isEqualTo(props.getProperty("displayed_title"));
//        // 3. Perform login
//        home.login(props.getProperty("username"), props.getProperty("password"));
//        // 4. Assert Username is loggined
//        softly.assertThat(home.getLoggedUserName())
//              .isEqualTo(props.getProperty("displayed_name"));
//        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
//        softly.assertThat((home.getUpperNavPanel().getNavElements()))
//              .hasSize(4)
//              .allMatch(WebElement::isDisplayed);
//
//        List<String> expectedUpperNames = Arrays.asList(props.getProperty("ex1_upper_items").split(";"));
//        softly.assertThat(getTextsOfElements(home.getUpperNavPanel().getNavElements()))
//              .isEqualTo(expectedUpperNames);
//        // 6. Assert that there are 4 images on the Index Page and they are displayed
//        softly.assertThat(home.getImages())
//              .hasSize(4)
//              .allMatch(WebElement::isDisplayed);
//        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
//        List<String> expectedImageCaptionTexts = Arrays.asList(props.getProperty("caption_texts").split(";"));
//        softly.assertThat(home.getImageCaptions())
//              .hasSize(4);
//        softly.assertThat(getTextsOfElements(home.getImageCaptions()))
//              .isEqualTo(expectedImageCaptionTexts);
//        // 8. Assert that there is the iframe with “Frame Button” exist
//        softly.assertThat(home.getIframesWithFrameButton())
//              .isNotEmpty();
//        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
//        webDriver.switchTo().frame(home.getIframesWithFrameButton().get(0));
//        List<WebElement> frameButtons = webDriver.findElements(By.id("frame-button"));
//        softly.assertThat(frameButtons)
//              .isNotEmpty();
//        // 10. Switch to original window back
//        webDriver.switchTo().parentFrame();
//        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
//        softly.assertThat((home.getLeftNavPanel().getNavElements()))
//              .hasSize(5)
//              .allMatch(WebElement::isDisplayed);
//
//        List<String> expectedLeftNames = Arrays.asList(props.getProperty("ex1_left_items").split(";"));
//        softly.assertThat(getTextsOfElements(home.getLeftNavPanel().getNavElements()))
//              .isEqualTo(expectedLeftNames);
//
//        softly.assertAll();
//        // 12. Close Browser
//        // handled by @AfterMethod
//    }

