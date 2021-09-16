package com.epam.tc.hw7_jdi;

import static com.epam.tc.hw7_jdi.HomePage.logout;
import static com.epam.tc.hw7_jdi.JdiSite.homePage;
import static com.epam.tc.hw7_jdi.JdiSite.loginAs;
import static com.epam.tc.hw7_jdi.JdiSite.open;
import static com.epam.tc.hw7_jdi.JdiTestDataProvider.EXPECTED_USERNAME;

import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test
    public void testMetalAndColorsSubmission() {
        open();
        loginAs(User.ROMAN);
        homePage.userName.assertThat().text(EXPECTED_USERNAME);

        logout();
    }
}
