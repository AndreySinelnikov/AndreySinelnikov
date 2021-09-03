package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.Utils.clickItem;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep {

    @When("I select {string} checkbox")
    public void selectCheckbox(String name) {
        clickItem(differentElementsPage.getCheckboxContainer(), name);
    }

    @When("I select {string} radio button")
    public void selectRadioButton(String name) {
        clickItem(differentElementsPage.getRadioButtonsContainer(), name);
    }

    @When("I select {string} in dropdown menu")
    public void selectDropdownItem(String name) {
        differentElementsPage.selectColor(name);
    }

    // Non-parameterized. Reasons: YAGNI and the lack of time
    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckboxForSergeyIvan() {
        userTablePage.clickVipForSergeyIvan();
    }
}
