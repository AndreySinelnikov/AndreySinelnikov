package com.epam.tc.hw7_jdi.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    @UI(".m-l8 li") public static Menu headerMenu;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @Css("#user-icon")
    public static Icon userIcon;
    @UI(".btn-login")
    public static Button logoutButton;

    public static void open() {
        homePage.open();
    }

    public static void logout() {
        userIcon.click();
        logoutButton.click();
    }
}
