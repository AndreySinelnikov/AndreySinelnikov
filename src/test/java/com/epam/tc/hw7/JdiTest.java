package com.epam.tc.hw7;

import static com.epam.tc.hw7.site.JdiSite.*;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;

import com.epam.tc.hw7.uiobjects.User;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {
    public Steps steps = new Steps();

    @Test
    public void userCanSubmitMetalsAndColorsForm() {
        // 1. Login on JDI site as User
        steps.loginOnJdiSiteAsUser();

    }
}
