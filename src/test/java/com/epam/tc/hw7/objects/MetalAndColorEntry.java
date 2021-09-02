package com.epam.tc.hw7.objects;

import com.epam.jdi.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class MetalAndColorEntry extends DataClass<MetalAndColorEntry> {
    public List<Integer> summary;
    // Summary: an abstract, recapitulation, or compendium of previously stated facts or statements.
    public List<String> elements;
    public String color;
    public List<String> metals;
    public List<String> vegetables;

    public static MetalAndColorEntry getDefaultMetalAndColorEntry() {
        MetalAndColorEntry def = new MetalAndColorEntry();
        def.summary = new ArrayList<Integer>(List.of(1, 2));
        def.elements = new ArrayList<String>(List.of("Water", "Fire"));
        def.color = "Red";
        def.metals = new ArrayList<String>(List.of("Gold"));
        def.vegetables = new ArrayList<String>(List.of("Cucumber"));
        return def;
    }
}
