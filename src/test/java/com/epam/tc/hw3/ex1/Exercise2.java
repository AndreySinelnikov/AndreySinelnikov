package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractExercise;
import com.epam.tc.hw3.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2 extends AbstractExercise {

    @Test
    public void exercise2() {
        HomePage home = new HomePage(webdriver, props.getProperty("homepage"));
        // 1. Open test site by URL
        home.load();
        // 2. Assert Browser title
        softly.assertThat(webdriver.getTitle())
              .isEqualTo(props.getProperty("displayed_title"));
        // 3. Perform login
        //home.getUpperNavPanel().login(props.getProperty("username"), props.getProperty("password"));
        home.login(props.getProperty("username"), props.getProperty("password"));
        // 4. Assert Username is loggined
        softly.assertThat(home.getLoggedUserName())
              .isEqualTo(props.getProperty("displayed_name"));
        // 5. Open through the header menu Service -> Different Elements Page

        softly.assertAll();
        // 12. Close Browser
        // handled by @AfterMethod
    }
}

//    // 5. Open through the header menu Service -> Different Elements Page
//    WebElement upperNavBar = webdriver.findElement(By.className("m-l8"));
//        upperNavBar.findElement(By.className("dropdown-toggle")).click();
//            upperNavBar.findElement(By.cssSelector("[href='different-elements.html']")).click();
//            // 6. Select checkboxes - Water, Wind;
//            webdriver.findElements(By.className("label-checkbox")).stream()
//            .filter(elem -> elem.getText().contains("Water") || elem.getText().contains("Wind"))
//            .forEach(WebElement::click);
//            // 7. Select radio - Selen
//            webdriver.findElements(By.className("label-radio")).stream()
//            .filter(elem -> elem.getText().contains("Selen"))
//            .forEach(WebElement::click);
//            // 8. Select in dropdown - Yellow
//            Select dropdown = new Select(webdriver.findElement(By.tagName("select")));
//            dropdown.selectByVisibleText("Yellow");
//            // 9. Assert there are log rows corresponding to steps 6, 7, 8 displaying toggled values
//            List<String> logEntries = webdriver.findElements(By.cssSelector(".logs li")).stream()
//    .map(WebElement::getText)
//    .map(entry -> entry.substring(9))
//    .collect(Collectors.toList());