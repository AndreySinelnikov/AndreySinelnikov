package com.epam.tc.hw7_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;

    public static void open() {
        homePage.open();
    }
}
