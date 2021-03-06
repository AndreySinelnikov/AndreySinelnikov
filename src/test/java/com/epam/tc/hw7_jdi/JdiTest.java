package com.epam.tc.hw7_jdi;

import static com.epam.tc.hw7_jdi.site.JdiSite.headerMenu;
import static com.epam.tc.hw7_jdi.site.JdiSite.logout;
import static com.epam.tc.hw7_jdi.site.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7_jdi.site.MetalsAndColorsPage.getResult;
import static com.epam.tc.hw7_jdi.site.MetalsAndColorsPage.metalsAndColorsForm;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7_jdi.entities.MetalsAndColorsEntry;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test(dataProvider = "testDataSet", dataProviderClass = JdiTestDataProvider.class)
    public void testMetalAndColorsSubmission(MetalsAndColorsEntry metalsAndColorsEntry) {
        // 2. Open Metals & Colors page by Header menu
        headerMenu.select("Metals & Colors");
        // Expected: Metals & Colors page is opened
        metalsAndColorsPage.checkOpened();
        // 3. Fill form Metals & Colors by JSON data
        metalsAndColorsForm.fill(metalsAndColorsEntry);
        metalsAndColorsForm.submit();
        // 4. Result sections should contain data from JSON
        assertThat(getResult())
            .isEqualTo(metalsAndColorsEntry.getExpectedResult());

        logout();
    }
}
