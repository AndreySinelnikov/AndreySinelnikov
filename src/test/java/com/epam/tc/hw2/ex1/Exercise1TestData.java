package com.epam.tc.hw2.ex1;


import java.util.List;
import java.util.Map;

class Exercise1TestData {
    static final List<String> UPPER_NAV_BAR_EXPECTED_TEXTS = List.of("HOME", "CONTACT FORM",
                                                                     "SERVICE", "METALS & COLORS");

    static final List<String> EXPECTED_TEXTS_UNDER_IMAGES = List.of("To include good practices\n"
            + "and ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
            );

    static final List<String> LEFT_SECTION_EXPECTED_TEXTS = List.of("Home", "Contact form",
                                                                          "Service", "Metals & Colors",
                                                                          "Elements packs");

    static final Map<String, String> TEST_USER_DATA = Map.of(
            "LOGIN", "Roman",
            "PASSWORD", "Jdi1234",
            "DISPLAYED_NAME", "ROMAN IOVLEV"
            );

    static final Map<String, String> URL_DATA = Map.of(
        "URL", "https://jdi-testing.github.io/jdi-light/index.html",
        "DISPLAYED_TITLE", "Home Page"
    );
}
