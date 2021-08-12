package com.epam.tc.hw2.ex2;

import static com.epam.tc.hw2.CommonTestData.TEST_USER_DATA;
import static com.epam.tc.hw2.CommonTestData.URL_DATA;
import static com.epam.tc.hw2.ex2.Exercise2TestData.EXPECTED_LOG_ENTRIES;

import com.epam.tc.hw2.Exercise;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Exercise2 extends Exercise {

    @Test
    public void exercise2() {
        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        webdriver.navigate().to(URL_DATA.get("URL"));
        // 2. Assert Browser title
        softly.assertThat(webdriver.getTitle())
              .isEqualTo(URL_DATA.get("DISPLAYED_TITLE"));
        // 3. Perform login
        webdriver.findElement(By.className("navbar-right")).click();
        webdriver.findElement(By.id("name")).sendKeys(TEST_USER_DATA.get("LOGIN"));
        webdriver.findElement(By.id("password")).sendKeys(TEST_USER_DATA.get("PASSWORD"));
        webdriver.findElement(By.id("login-button")).click();
        // 4. Assert Username is loggined
        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id=\"user-name\" and not(@class=\"hidden\")]"));
        softly.assertThat(nameLabel.getText())
              .isEqualTo(TEST_USER_DATA.get("DISPLAYED_NAME"));
        // 5. Open through the header menu Service -> Different Elements Page
        WebElement upperNavBar = webdriver.findElement(By.className("m-l8"));
        upperNavBar.findElement(By.className("dropdown-toggle")).click();
        upperNavBar.findElement(By.cssSelector("[href='different-elements.html']")).click();
        // 6. Select checkboxes - Water, Wind;
        webdriver.findElements(By.className("label-checkbox")).stream()
                .filter(elem -> elem.getText().contains("Water") || elem.getText().contains("Wind"))
                .forEach(WebElement::click);
        // 7. Select radio - Selen
        webdriver.findElements(By.className("label-radio")).stream()
                .filter(elem -> elem.getText().contains("Selen"))
                .forEach(WebElement::click);
        // 8. Select in dropdown - Yellow
        Select dropdown = new Select(webdriver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Yellow");
        // 9. Assert there are log rows corresponding to steps 6, 7, 8 displaying toggled values
        List<String> logEntries = webdriver.findElements(By.cssSelector(".logs li")).stream()
                                           .map(WebElement::getText)
                                           .map(entry -> entry.substring(9))
                                           .collect(Collectors.toList());

        softly.assertThat(logEntries.containsAll(EXPECTED_LOG_ENTRIES)).isTrue();

        softly.assertAll();
        // 10. Close browser
    }
}
