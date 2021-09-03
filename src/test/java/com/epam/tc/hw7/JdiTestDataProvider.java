package com.epam.tc.hw7;

import static com.epam.tc.hw7.objects.MetalAndColorEntry.example;

import org.testng.annotations.DataProvider;

public class JdiTestDataProvider {
    public static final String EXPECTED_USERNAME = "ROMAN IOVLEV";

    @DataProvider(name = "JdiTestDataSet")
    public static Object[][] getJdiTestData() {
        return new Object[][]{{example}};
    }
}
