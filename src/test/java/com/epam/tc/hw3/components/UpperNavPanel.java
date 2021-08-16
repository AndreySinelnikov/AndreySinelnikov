package com.epam.tc.hw3.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperNavPanel extends BaseComponent {

    public UpperNavPanel(WebDriver webdriver) {
        super(webdriver);
    }

    public List<WebElement> getNavElements() {
        // locator gets only the direct children of navbar container
        return webdriver.findElements(By.cssSelector(".m-l8 > li"));
    }

    public List<String> getTextsOfNavElements() {
        return getNavElements().stream()
                               .map(WebElement::getText)
                               .collect(Collectors.toList());
    }
}
