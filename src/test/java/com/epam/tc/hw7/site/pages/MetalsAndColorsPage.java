package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.site.sections.MetalAndColorEntryForm;
import java.util.Arrays;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")  // (sic)
public class MetalsAndColorsPage extends WebPage {
    @Css("form") public static MetalAndColorEntryForm metalAndColorEntryForm;
    @UI(".summ-res") public UIElement summaryResult;
    @UI(".elem-res") public UIElement elementsResult;
    @UI(".col-res") public UIElement colorResult;
    @UI(".met-res") public UIElement metalResult;
    @UI(".sal-res") public UIElement vegetablesResult;

    public String getSummary() {
        return summaryResult.getText().replace("Summary: ", "");
    }

    public List<String> getElems() {
        String elems = elementsResult.getText().replace("Elements: ", "");
        return Arrays.asList(elems.split(", "));
    }

    public String getColor() {
        return colorResult.getText().replace("Color: ", "");
    }

    public String getMetal() {
        return metalResult.getText().replace("Metal: ", "");
    }

    public List<String> getVegetables() {
        String elems = vegetablesResult.getText().replace("Vegetables: ", "");
        return Arrays.asList(elems.split(", "));
    }
}
