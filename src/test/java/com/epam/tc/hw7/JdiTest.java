package com.epam.tc.hw7;

import static com.epam.tc.hw7.site.JdiSite.*;

import com.epam.tc.hw7.uiobjects.User;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {
    public static User DEFAULT_USER = new User();

    @Test
    public void userCanSubmitMetalsAndColorsForm() {
        // 1. Login on JDI site as User
        //throw new UnsupportedOperationException();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
    }
}
