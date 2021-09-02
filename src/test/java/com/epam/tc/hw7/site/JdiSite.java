package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @UI(".m-l8 li") public static Menu headerMenu;
    //@Css("form") public static Form<User> loginForm;

    //    @Css(".profile-photo [ui=label]") public static UIElement userName;
    //    @Css(".logout") public static WebElement logout;
    //@Css("img#user-icon") public static UIElement userIcon;
    //    @UI(".sidebar-menu li") public static Menu leftMenu;
    //    @UI(".sidebar-menu li") public static JList<MenuItem> menu;

}

