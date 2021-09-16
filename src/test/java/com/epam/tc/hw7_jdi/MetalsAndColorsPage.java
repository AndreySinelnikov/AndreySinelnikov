package com.epam.tc.hw7_jdi;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @Css("form")
    public static MetalsAndColorsForm metalsAndColorsForm;
    @Css("#user-icon")
    public static Icon userIcon;
    @UI(".btn-login")
    public static Button logoutButton;

    @Css(".results li")
    private static List<UIElement> resultTab;

    public static void logout() {
        userIcon.click();
        logoutButton.click();
    }

    public static List<String> getResult() {
        return resultTab.stream()
                        .map(UIElement::getText)
                        .collect(Collectors.toList());
    }
}
