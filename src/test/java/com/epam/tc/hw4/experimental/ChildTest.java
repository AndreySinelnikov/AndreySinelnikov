package com.epam.tc.hw4.experimental;

import com.epam.tc.hw4.AbstractExercise;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ChildTest extends AbstractExercise {

    @Test
    @Feature("Homework 4")
    @Story("Exercise 1")
    public void simpleTest() {
        // 1. Open test site by URL
        actionStep.openHomePage();
        // 2. Assert Browser title
        assertionStep.homePageTitleShouldBeEqualToExpected(props.getProperty("expected_homepage_title"));
    }
}
