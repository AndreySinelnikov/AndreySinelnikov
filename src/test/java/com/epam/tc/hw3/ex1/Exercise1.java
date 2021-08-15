package com.epam.tc.hw3.ex1;


import com.epam.tc.hw3.AbstractExercise;
import com.epam.tc.hw3.pages.HomePage;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends AbstractExercise {

    @Test
    public void exercise1() {
        HomePage home = new HomePage(webdriver, properties.getProperty("homepage"));
        // 1. Open test site by URL
        home.open();
        // 2. Assert Browser title
        softly.assertThat(webdriver.getTitle())
              .isEqualTo(properties.getProperty("displayed_title"));
        // 3. Perform login
        home.getUpperNavPanel().login(properties.getProperty("username"), properties.getProperty("password"));
        // 4. Assert Username is loggined
        softly.assertThat(home.getUpperNavPanel().getLoggedUserName())
              .isEqualTo(properties.getProperty("displayed_name"));
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedUpperNames = Arrays.asList(properties.getProperty("ex1_upper_items").split(","));
        softly.assertThat((home.getUpperNavPanel().getNavElements()))
              .hasSize(4)
              .allMatch(WebElement::isDisplayed);
        softly.assertThat(home.getUpperNavPanel().getTextsOfNavElements())
              .isEqualTo(expectedUpperNames);
        // 6. Assert that there are 4 images on the Index Page and they are displayed



        //        WebElement nameLabel = webdriver.findElement(By.xpath("//*[@id=\"user-name\" and not(@class=\"hidden\")]"));
        //        softly.assertThat(nameLabel.getText())
        //              .isEqualTo(TEST_USER_DATA.get("DISPLAYED_NAME"));
        //        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //        WebElement upperNavBar = webdriver.findElement(By.className("m-l8"));
        //        softly.assertThat(getDirectChildren(upperNavBar))
        //              .hasSize(4)
        //              .allMatch(WebElement::isDisplayed);
        //        softly.assertThat(getListOfDirectChildrenTexts(upperNavBar))
        //              .isEqualTo(UPPER_NAV_BAR_EXPECTED_TEXTS);
        //        // 6. Assert that there are 4 images on the Index Page and they are displayed
        //        WebElement imageRow = webdriver.findElement(By.cssSelector(".row.clerafix.benefits"));
        //        List<WebElement> images = imageRow.findElements(By.className("benefit-icon"));
        //        softly.assertThat(images)
        //              .hasSize(4)
        //              .allMatch(WebElement::isDisplayed);
        //        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //        List<String> textsUnderImages = imageRow.findElements(By.className("benefit-txt")).stream()
        //                                                .map(elem -> elem.getAttribute("innerText"))
        //                                                .collect(Collectors.toList());
        //        softly.assertThat(textsUnderImages)
        //              .hasSize(4)
        //              .isEqualTo(EXPECTED_TEXTS_UNDER_IMAGES);
        //        // 8. Assert that there is the iframe with “Frame Button” exist
        //        List<WebElement> iframes = webdriver
        //            .findElements(By.cssSelector("[src='https://jdi-testing.github.io/jdi-light/frame-button.html']"));
        //        softly.assertThat(iframes.isEmpty())
        //              .isFalse();
        //        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        //        webdriver.switchTo().frame(iframes.get(0));
        //        softly.assertThat(webdriver.findElements(By.id("frame-button")).isEmpty())
        //              .isFalse();
        //        // 10. Switch to original window back
        //        webdriver.switchTo().parentFrame();
        //        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //        WebElement leftSection = webdriver.findElement(By.cssSelector(".sidebar-menu.left"));
        //        softly.assertThat(getDirectChildren(leftSection))
        //              .hasSize(5)
        //              .allMatch(WebElement::isDisplayed);
        //        softly.assertThat(getListOfDirectChildrenTexts(leftSection))
        //              .isEqualTo(LEFT_SECTION_EXPECTED_TEXTS);
        //
        //        softly.assertAll();
        //        // 12. Close Browser



        softly.assertAll();

    }
}
