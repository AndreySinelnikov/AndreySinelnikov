package com.epam.tc.hw3.ex2;

import static com.epam.tc.hw3.Utils.clickItem;

import com.epam.tc.hw3.AbstractExercise;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise2 extends AbstractExercise {

    @Test
    public void exercise2() {
        HomePage home = new HomePage(webDriver, props.getProperty("homepage_url"));
        // 1. Open test site by URL
        home.open();
        // 2. Assert Browser title
        softly.assertThat(webDriver.getTitle())
              .isEqualTo(props.getProperty("expected_homepage_title"));
        // 3. Perform login
        home.login(props.getProperty("username"), props.getProperty("password"));
        // 4. Assert Username is loggined
        softly.assertThat(home.getLoggedUserName())
              .isEqualTo(props.getProperty("expected_user"));
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage diffElemPage = home.openDifferentElementsPage(props.getProperty("elements_page_url"));
        // 6. Select checkboxes - Water, Wind;
        clickItem(diffElemPage.getCheckboxContainer(), "Water");
        clickItem(diffElemPage.getCheckboxContainer(), "Wind");
        // 7. Select radio - Selen
        clickItem(diffElemPage.getRadioButtonsContainer(), "Selen");
        // 8. Select in dropdown - Yellow
        diffElemPage.selectColor("Yellow");
        // 9. Assert there are log rows corresponding to steps 6, 7, 8 displaying toggled values
        List<String> expectedLogEntries = Arrays.asList(props.getProperty("expected_log_entries").split(";"));
        softly.assertThat(diffElemPage.getLogDisplayComponent().getLogEntriesWithoutDates())
              .containsAll(expectedLogEntries);

        softly.assertAll();
        // 12. Close Browser
        // handled by @AfterMethod
    }
}
