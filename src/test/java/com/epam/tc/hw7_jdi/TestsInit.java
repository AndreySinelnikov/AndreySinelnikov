package com.epam.tc.hw7_jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7_jdi.JdiTestDataProvider.EXPECTED_USERNAME;
import static com.epam.tc.hw7_jdi.entities.User.ROMAN;
import static com.epam.tc.hw7_jdi.site.HomePage.loginAs;
import static com.epam.tc.hw7_jdi.site.JdiSite.homePage;
import static com.epam.tc.hw7_jdi.site.JdiSite.open;

import com.epam.tc.hw7_jdi.site.JdiSite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {
    @BeforeSuite
    static void setUpSuite() {
        initSite(JdiSite.class);
    }

    @BeforeMethod
    static void setUpMethod() {
        // 1. Login on JDI site as User
        open();
        loginAs(ROMAN);
        // Expected: Roman Iovlev is logged in
        homePage.userName.assertThat().text(EXPECTED_USERNAME);
    }
}