package com.epam.tc.hw7_jdi;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import org.testng.annotations.BeforeSuite;

public interface TestsInit {
    @BeforeSuite
    static void setUp() {
        initSite(JdiSite.class);
    }
}
