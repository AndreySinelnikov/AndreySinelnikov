package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.Utils.clickItem;

import com.epam.tc.hw5.cucumber.TestContext;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    public GivenStep() {
        super();
    }

    @Given("I open JDI GitHub site")
    public void openJdiSite() {
        homePage.open();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void loginAsRomanIovlev() {
        homePage.login(TestContext.getInstance().getTestObject("username"),
            TestContext.getInstance().getTestObject("password"));
    }

    // clickItem method works only with SERVICE passed into it, so I went with quick hacks instead of parameterization
    @Given("I click on \"Service\" button in Header")
    public void clickOnHeaderServiceButton() {
        homePage.getUpperNavPanel().clickServiceButton();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButton() {
        homePage.getUpperNavPanel().clickUserTableButton();
    }

    @Given("I click on \"Different elements\" button in Service dropdown")
    public void clickOnDifferentElementsButton() {
        homePage.getUpperNavPanel().clickDifferentElementsButton();
    }
}
