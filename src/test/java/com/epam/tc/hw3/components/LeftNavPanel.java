package com.epam.tc.hw3.components;

import static com.epam.tc.hw3.Utils.getDirectChildren;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftNavPanel extends BaseComponent {
    @FindBy(css = ".sidebar-menu.left")
    private WebElement navElementContainer;

    public LeftNavPanel(WebDriver webdriver) {
        super(webdriver);
    }

    public List<WebElement> getNavElements() {
        return getDirectChildren(navElementContainer);
    }

    public List<String> getTextsOfNavElements() {
        return getNavElements().stream()
                               .map(WebElement::getText)
                               .collect(Collectors.toList());
    }
 }
