package com.epam.tc.hw3.components;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperNavPanel extends BaseComponent {
    @FindBy(className = "m-l8")
    private WebElement navElementContainer;

    public UpperNavPanel(WebDriver webdriver) {
        super(webdriver);
    }

    public List<WebElement> getNavElements() {
        return navElementContainer.findElements(By.xpath("./*"));
    }

    public List<String> getTextsOfNavElements() {
        return getNavElements().stream()
                               .map(WebElement::getText)
                               .collect(Collectors.toList());
    }

//    public DifferentElementsPage openElementsPage() {
//        selectNavElement("Service");
//    }

    public void selectNavElement(String name) {
        getNavElements().stream()
                        .filter(elem -> elem.getText().trim().equals(name))
                        .forEach(WebElement::click);
    }
}