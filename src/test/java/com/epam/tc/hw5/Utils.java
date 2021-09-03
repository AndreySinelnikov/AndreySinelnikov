package com.epam.tc.hw5;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils {

    public static List<WebElement> getDirectChildren(WebElement elem) {
        return elem.findElements(By.xpath("./*"));
    }

    public static void clickItem(List<WebElement> elems, String name) {
        elems.stream()
            .filter(elem -> elem.getText().trim().equals(name))
            .forEach(WebElement::click);
    }
}
