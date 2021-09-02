package com.epam.tc.hw7.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.objects.MetalAndColorEntry;

public class MetalAndColorEntryForm extends Form<MetalAndColorEntry> {
    @UI("[name='custom_radio_odd']") public RadioButtons odds;
    @UI("[name='custom_radio_even']") public RadioButtons evens;
    @UI("#calculate-button") public Button calculate;
    @UI("#elements-checklist [type=checkbox]") public Checklist elements;
    @JDropdown(root = "div#colors",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown color;
    @JDropdown(root = "div#metals",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown metals;
    @JDropdown(root = "div#vegetables",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown vegetables;

    @UI("['Submit']") public Button submit;

    @Override
    public void fill(MetalAndColorEntry entry) {
        odds.select(entry.summary.get(0).toString());
        evens.select(entry.summary.get(1).toString());
        calculate.click();
        entry.elements.forEach(elements::select);
        color.select(entry.color);
        entry.metals.forEach(metals::select);
        entry.vegetables.forEach(vegetables::select);
    }
}
