package com.epam.tc.hw7_jdi;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.objects.User;
import com.epam.tc.hw7.site.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("#user-icon")
    public static Icon userIcon;
    @Css("form")
    public static LoginForm loginForm;
    @Css("#user-name")
    public static Label userName;
    @UI(".btn-login")
    public static Button logoutButton;

    public void loginAs(User user) {
        userIcon.click();
        loginForm.login(user);
    }
}