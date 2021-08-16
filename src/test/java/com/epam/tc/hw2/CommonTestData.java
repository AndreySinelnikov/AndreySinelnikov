package com.epam.tc.hw2;

import java.util.Map;

public class CommonTestData {

    public static final Map<String, String> TEST_USER_DATA = Map.of(
        "LOGIN", "Roman",
        "PASSWORD", "Jdi1234",
        "DISPLAYED_NAME", "ROMAN IOVLEV"
    );

    public static final Map<String, String> URL_DATA = Map.of(
        "URL", "https://jdi-testing.github.io/jdi-light/index.html",
        "DISPLAYED_TITLE", "Home Page"
    );
}
