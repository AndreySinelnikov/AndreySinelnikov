package com.epam.tc.hw3.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogDisplayComponent extends AbstractComponent {
    @FindBy(css = ".logs li")
    private List<WebElement> logEntryContainer;

    public LogDisplayComponent(WebDriver webdriver) {
        super(webdriver);
    }

    public List<String> getLogEntriesWithoutDates() {
        return logEntryContainer.stream()
                         .map(WebElement::getText)
                         .map(entry -> entry.substring(9))
                         .collect(Collectors.toList());
    }
}
