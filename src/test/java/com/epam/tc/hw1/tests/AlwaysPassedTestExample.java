package com.epam.tc.hw1.tests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AlwaysPassedTestExample {

    @Test
    public void alwaysPassedTest() {
        assertThat(true);
    }
}
