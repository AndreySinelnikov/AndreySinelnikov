package com.epam.tc.hw2;

import java.util.List;
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

    public static final List<String> EXPECTED_LOG_ENTRIES = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true"
    );
}
