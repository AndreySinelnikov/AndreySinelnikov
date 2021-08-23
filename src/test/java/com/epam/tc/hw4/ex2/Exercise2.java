package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.AbstractExercise;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise2 extends AbstractExercise {

    @Test
    @Feature("Homework 4")
    @Story("Exercise 2")
    public void exercise2() {
        // 1. Open test site by URL
        actionStep.openHomePage();
        // 2. Assert Browser title
        assertionStep.homePageTitleShouldBeEqualToExpected(props.getProperty("expected_homepage_title"));
        // 3. Perform login
        actionStep.login(props.getProperty("username"), props.getProperty("password"));
        // 4. Assert Username is loggined
        assertionStep.displayedUserShouldBeEqualToExpected(props.getProperty("expected_user"));
        // 5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage(props.getProperty("elements_page_url"));
        // 6. Select checkboxes - Water, Wind;
        actionStep.selectElementCheckbox(props.getProperty("checkbox_1"));
        actionStep.selectElementCheckbox(props.getProperty("checkbox_2"));
        // 7. Select radio - Selen
        actionStep.selectRadioButton(props.getProperty("radio_button"));
        // 8. Select in dropdown - Yellow
        actionStep.selectColor(props.getProperty("color"));
        // 9. Assert there are log rows corresponding to steps 6, 7, 8 displaying toggled values
        assertionStep.selectActionsShouldBeLogged(props.getProperty("expected_log_entries"));
        // 12. Close Browser
        // Handled by @AfterMethod
    }

}
