package com.epam.tc.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<WebElement> getDirectChildren(WebElement elem) {
        return new ArrayList<>(elem.findElements(By.xpath("./*")));
    }

    public static List<String> getListOfDirectChildrenTexts(WebElement elem) {
        return getDirectChildren(elem).stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toList());
    }
}
