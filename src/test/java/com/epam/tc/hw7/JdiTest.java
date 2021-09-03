package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.tc.hw7.JdiTestDataProvider.EXPECTED_USERNAME;
import static com.epam.tc.hw7.site.JdiSite.headerMenu;
import static com.epam.tc.hw7.site.JdiSite.homePage;
import static com.epam.tc.hw7.site.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;
import static com.epam.tc.hw7.site.pages.HomePage.userName;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalAndColorEntryForm;

import com.epam.tc.hw7.objects.MetalAndColorEntry;
import com.epam.tc.hw7.objects.User;
import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test(dataProvider = "JdiTestDataSet", dataProviderClass = JdiTestDataProvider.class)
    public void userCanSubmitMetalsAndColorsForm(MetalAndColorEntry entry) {

        // 1. Login on JDI site as User
        userIcon.click();
        loginForm.loginAs(User.ROMAN);
        // Expected: Roman Iovlev is logged in
        userName.assertThat().text(EXPECTED_USERNAME);
        // 2. Open Metals & Colors page by Header menu
        headerMenu.select("Metals & Colors");
        // Expected: Metals & Colors page is opened
        metalsAndColorsPage.checkOpened();
        // 3. Fill form Metals & Colors by JSON data
        metalAndColorEntryForm.fill(entry);
        // (no number) Submit form Metals & Colors
        metalAndColorEntryForm.submit();
        // 4. Result sections should contain data from JSON

    }
}
