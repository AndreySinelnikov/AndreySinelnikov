package com.epam.tc.hw7;

import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;

import com.epam.tc.hw7.objects.User;
import io.qameta.allure.Step;

public class Steps {

    @Step("Login on JDI site as User")
    public void loginOnJdiSiteAsUser() {
        userIcon.click();
        loginForm.loginAs(new User());
    }

    @Step("Open Metals & Colors page by Header menu")
    public void openMetalsAndColorsPageByHeaderMenu() {
        throw new UnsupportedOperationException();
    }

    @Step("Fill form Metals & Colors by data from JSON")
    public void fillFormMetalsAndColorsWithJsonData() {
        throw new UnsupportedOperationException();
    }

    @Step("Submit form Metals & Colors")
    public void submitMetalsAndColorsForm() {
        throw new UnsupportedOperationException();
    }

    @Step("Result sections should contains data from JSON")
    public void assertThatResultSectionContainsDataFromJson() {
        throw new UnsupportedOperationException();
    }
}
