package com.epam.tc.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    @Test
    public void exercise2() {
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
        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id='user-name' and not(@class= 'hidden')]"));
        softAssert.assertEquals(nameLabel.getText(), "ROMAN IOVLEV");
        // 5. Open through the header menu Service -> Different Elements Page
        WebElement upperNavBar = webdriver.findElements(By.className("m-l8")).get(0);
        upperNavBar.findElement(By.className("dropdown-toggle")).click();
        upperNavBar.findElement(By.cssSelector("[href='different-elements.html']")).click();
        // 6. Select checkboxes - Water, Wind;
        List<WebElement> checkboxes = webdriver.findElements(By.className("label-checkbox"));
        for (WebElement checkbox: checkboxes) {
            if (checkbox.getText().contains("Water") || checkbox.getText().contains("Wind")) {
                checkbox.click();
            }
        }
        // 7. Select radio - Selen
        List<WebElement> radios = webdriver.findElements(By.className("label-radio"));
        for (WebElement radio: radios) {
            if (radio.getText().contains("Selen")) {
                radio.click();
                break;
            }
        }
        // 8. Select in dropdown - Yellow
        Select dropdown = new Select(webdriver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Yellow");
        // 9. Assert there are log rows corresponding to steps 6, 7, 8 displaying toggled values
        List<String> logEntries = webdriver.findElements(By.cssSelector(".logs li")).stream()
                .map(WebElement::getText)
                .map(entry -> entry.substring(9))
                .collect(Collectors.toList());

        softAssert.assertTrue(logEntries.contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logEntries.contains("metal: value changed to Selen"));
        softAssert.assertTrue(logEntries.contains("Wind: condition changed to true"));
        softAssert.assertTrue(logEntries.contains("Water: condition changed to true"));

        softAssert.assertAll();
        // 10. Close browser
        webdriver.quit();
    }
}
