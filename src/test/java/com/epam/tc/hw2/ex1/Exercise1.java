package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.Utils.getDirectChildren;
import static com.epam.tc.hw2.Utils.getListOfDirectChildrenTexts;
import static com.epam.tc.hw2.ex1.Exercise1TestData.EXPECTED_TEXTS_UNDER_IMAGES;
import static com.epam.tc.hw2.ex1.Exercise1TestData.LEFT_SECTION_EXPECTED_TEXTS;
import static com.epam.tc.hw2.ex1.Exercise1TestData.TEST_USER_DATA;
import static com.epam.tc.hw2.ex1.Exercise1TestData.UPPER_NAV_BAR_EXPECTED_TEXTS;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercise1 {

    @Test
    public void exercise1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Selenium\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        softly.assertThat(webdriver.getTitle())
                .isEqualTo("Home Page");
        // 3. Perform login
        List<WebElement> loginDropdowns = webdriver.findElements(By.className("navbar-right"));
        loginDropdowns.get(0).click();
        webdriver.findElement(By.id("name")).sendKeys(TEST_USER_DATA.get("LOGIN"));
        webdriver.findElement(By.id("password")).sendKeys(TEST_USER_DATA.get("PASSWORD"));
        webdriver.findElement(By.id("login-button")).click();
        // 4. Assert Username is loggined
        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id=\"user-name\" and not(@class=\"hidden\")]"));
        softly.assertThat(nameLabel.getText())
                .isEqualTo(TEST_USER_DATA.get("DISPLAYED_NAME"));
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement upperNavBar = webdriver.findElements(By.className("m-l8")).get(0);
        softly.assertThat(getDirectChildren(upperNavBar))
                .hasSize(4)
                .allMatch(WebElement::isDisplayed);
        softly.assertThat(getListOfDirectChildrenTexts(upperNavBar))
                .isEqualTo(UPPER_NAV_BAR_EXPECTED_TEXTS);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        WebElement imageRow = webdriver.findElements(By.cssSelector(".row.clerafix.benefits")).get(0);
        List<WebElement> images = imageRow.findElements(By.className("benefit-icon"));
        softly.assertThat(images)
                .hasSize(4)
                .allMatch(WebElement::isDisplayed);
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> textsUnderImages = imageRow.findElements(By.className("benefit-txt")).stream()
                .map(elem -> elem.getAttribute("innerText"))
                .collect(Collectors.toList());
        softly.assertThat(textsUnderImages)
                .hasSize(4)
                .isEqualTo(EXPECTED_TEXTS_UNDER_IMAGES);
        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> iframes = webdriver
                .findElements(By.cssSelector("[src='https://jdi-testing.github.io/jdi-light/frame-button.html']"));
        softly.assertThat(iframes.isEmpty())
                .isFalse();
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame(iframes.get(0));
        softly.assertThat(webdriver.findElements(By.id("frame-button")).isEmpty())
                .isFalse();
        // 10. Switch to original window back
        webdriver.switchTo().parentFrame();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement leftSection = webdriver.findElements(By.cssSelector(".sidebar-menu.left")).get(0);
        softly.assertThat(getDirectChildren(leftSection))
                .hasSize(5)
                .allMatch(WebElement::isDisplayed);
        softly.assertThat(getListOfDirectChildrenTexts(leftSection))
                .isEqualTo(LEFT_SECTION_EXPECTED_TEXTS);

        softly.assertAll();
        // 12. Close Browser
        //webdriver.quit();
    }
}
