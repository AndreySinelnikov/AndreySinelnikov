package com.epam.tc.hw4.ex1;


import com.epam.tc.hw4.AbstractExercise;
import com.epam.tc.hw4.AllureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
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
        // Handled by @AfterMethod
    }
}


