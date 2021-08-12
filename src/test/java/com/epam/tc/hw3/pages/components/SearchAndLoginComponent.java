package com.epam.tc.hw3.pages.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAndLoginComponent {
    @FindBy(className = "navbar-right")
    private List<WebElement> contents;

}
