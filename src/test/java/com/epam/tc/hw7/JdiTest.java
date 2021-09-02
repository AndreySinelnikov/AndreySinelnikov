package com.epam.tc.hw7;

//import static com.epam.tc.hw7.site.JdiSite.*;
import static com.epam.tc.hw7.site.JdiSite.headerMenu;
import static com.epam.tc.hw7.site.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalAndColorEntryForm;

import com.epam.tc.hw7.objects.MetalAndColorEntry;
import com.epam.tc.hw7.objects.User;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test
    public void userCanSubmitMetalsAndColorsForm() {
        // 1. Login on JDI site as User
        userIcon.click();
        loginForm.loginAs(new User());
        // 2. Open Metals & Colors page by Header menu
        headerMenu.select("Metals & Colors");
        // 3. Fill form Metals & Colors by JSON data
        metalAndColorEntryForm.fill(MetalAndColorEntry.getDefaultMetalAndColorEntry());
        // (no number) Submit form Metals & Colors
        metalAndColorEntryForm.submit();
        // 4. Result sections should contain data from
    }
}
