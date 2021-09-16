package com.epam.tc.hw7_jdi;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    @UI(".m-l8 li") public static Menu headerMenu;
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }
}
