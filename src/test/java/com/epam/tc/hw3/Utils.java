package com.epam.tc.hw3;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils {

    public static List<WebElement> getDirectChildren(WebElement elem) {
        return elem.findElements(By.xpath("./*"));
    }

    public static List<String> getTextsOfElements(List<WebElement> elems) {
        return elems.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
