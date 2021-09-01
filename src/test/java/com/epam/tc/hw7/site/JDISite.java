package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.uiobjects.User;

//@JSite("https://jdi-testing.github.io/jdi-light/")
public class JDISite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @Css("form") public static Form<User> loginForm;

    //    @Css(".profile-photo [ui=label]") public static UIElement userName;
    //    @Css(".logout") public static WebElement logout;
    //    @Css("img#user-icon") public static UIElement userIcon;
    //    @UI(".sidebar-menu li") public static Menu leftMenu;
    //    @UI(".sidebar-menu li") public static JList<MenuItem> menu;
}

