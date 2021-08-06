package com.epam.tc.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
        webdriver.findElement(By.id("name")).sendKeys("Roman");
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();
        // 4. Assert Username is loggined
        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id=\"user-name\" and not(@class=\"hidden\")]"));
        softAssert.assertEquals(nameLabel.getText(), "ROMAN IOVLEV");
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement upperNavBar = webdriver.findElements(By.className("m-l8")).get(0);
        //WebElement home = upperNavBar.findElement(By.xpath("//*[text() = 'HOME']"));
        //softAssert.assertTrue(home.isDisplayed());

        softAssert.assertAll();
    }
}
