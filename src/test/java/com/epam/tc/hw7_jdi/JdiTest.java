package com.epam.tc.hw7_jdi;

import static com.epam.tc.hw7_jdi.JdiSite.loginAs;
import static com.epam.tc.hw7_jdi.JdiSite.open;

import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test
    public void testMetalAndColorsSubmission() {
        open();
        loginAs(User.ROMAN);
    }
}
