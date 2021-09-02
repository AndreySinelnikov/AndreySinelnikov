package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.sections.MetalAndColorEntryForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")  // (sic)
public class MetalsAndColorsPage extends WebPage {
    @Css("form") public static MetalAndColorEntryForm metalAndColorEntryForm;
}
