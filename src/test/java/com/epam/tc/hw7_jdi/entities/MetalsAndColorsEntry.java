package com.epam.tc.hw7_jdi.entities;

import static java.lang.String.format;
import static java.lang.String.join;

import com.epam.jdi.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsEntry extends DataClass<MetalsAndColorsEntry> {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public List<String> getExpectedResult() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(format("Summary: %s", ((summary.get(0) + summary.get(1)))));
        expectedResult.add(format("Elements: %s", join(", ", elements)));
        expectedResult.add(format("Color: %s", color));
        expectedResult.add(format("Metal: %s", metals));
        expectedResult.add(format("Vegetables: %s", join(", ", vegetables)));
        return expectedResult;
    }
}
