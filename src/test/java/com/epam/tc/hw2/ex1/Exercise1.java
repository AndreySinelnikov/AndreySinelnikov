package com.epam.tc.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise1 {

    @Test
    public void exercise1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Selenium\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        softAssert.assertEquals("Home Page", webdriver.getTitle());
        // 3. Perform login
        List<WebElement> loginDropdowns = webdriver.findElements(By.className("navbar-right"));
        loginDropdowns.get(0).click();
        webdriver.findElement(By.id("name")).sendKeys("Roman"); // refactor to external source
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();
        // 4. Assert Username is loggined
        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id=\"user-name\" and not(@class=\"hidden\")]"));
        softAssert.assertEquals(nameLabel.getText(), "ROMAN IOVLEV");
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement upperNavBar = webdriver.findElements(By.className("m-l8")).get(0);
        //WebElement home = upperNavBar.findElement(By.xpath("//*[text() = 'HOME']"));
        //softAssert.assertTrue(home.isDisplayed());

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iFramesWithFrameButton = webdriver
                .findElements(By.cssSelector("[src='https://jdi-testing.github.io/jdi-light/frame-button.html']"));
        softAssert.assertFalse(iFramesWithFrameButton.isEmpty());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame(iFramesWithFrameButton.get(0));
        softAssert.assertFalse(webdriver.findElements(By.id("frame-button")).isEmpty());
        // 10. Switch to original window back
        webdriver.switchTo().parentFrame();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement leftSidebar = webdriver.findElements(By.cssSelector(".sidebar-menu.left")).get(0);
        List<WebElement> leftSidebarDirectChildren = new ArrayList<>(leftSidebar.findElements(By.xpath("./*")));
        softAssert.assertTrue(leftSidebarDirectChildren.stream().allMatch(WebElement::isDisplayed));

        List<String> properTextList = List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<String> actualTextList = leftSidebarDirectChildren.stream().map(WebElement::getText)
                                                                        .collect(Collectors.toList());
        softAssert.assertEquals(actualTextList, properTextList);

        softAssert.assertAll();
    }
}
