package com.epam.tc.hw7_jdi.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7_jdi.entities.MetalsAndColorsEntry;

public class MetalsAndColorsForm extends Form<MetalsAndColorsEntry> {
    @JDropdown(root = "div#colors",
               value = ".filter-option",
               list = "li",
               expand = ".caret"
    )
    public static Dropdown colors;

    @JDropdown(root = "div#metals",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown metals;

    @UI("#elements-checklist input")
    public static Checklist elementsChecklist;

    @UI("section.horizontal-group input")
    public static RadioButtons summaryRadioButtons;

    @JDropdown(root = "#vegetables",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown vegetablesDropdown;

    @UI("button#submit-button")
    public Button submitButton;

    @Override
    public void fill(MetalsAndColorsEntry metalsAndColorsEntry) {
        summaryRadioButtons.select(metalsAndColorsEntry.summary.get(0).toString());
        summaryRadioButtons.select(metalsAndColorsEntry.summary.get(1).toString());
        metalsAndColorsEntry.elements.forEach(elementsChecklist::select);
        colors.select(metalsAndColorsEntry.color);
        metals.select(metalsAndColorsEntry.metals);
        vegetablesDropdown.select("Vegetables"); // deselect pre-selected option
        for (String vegetable : metalsAndColorsEntry.vegetables) {
            vegetablesDropdown.select(vegetable);
        }
    }

    @Override
    public void submit() {
        submitButton.click();
    }
}
