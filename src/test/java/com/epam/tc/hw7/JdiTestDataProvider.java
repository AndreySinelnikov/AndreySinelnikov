package com.epam.tc.hw7;

import com.epam.tc.hw7.objects.MetalAndColorEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.DataProvider;

public class JdiTestDataProvider {
    public static final String EXPECTED_USERNAME = "ROMAN IOVLEV";
    public static final String DATASET_PATH = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "JdiTestDataSet")
    public static Object[][] getJdiTestData() {
        Object[][] testData = new Object[5][1];
        Object[] entries = createMetalAndColorEntryArrayFromJson(5, 2, DATASET_PATH);
        for (int i = 0; i < entries.length; i++) {
            testData[i][0] = entries[i];
        }
        return testData;
    }

    public static MetalAndColorEntry[] createMetalAndColorEntryArrayFromJson(int elems, int offset, String path) {
        MetalAndColorEntry[] entryArray = new MetalAndColorEntry[elems];
        int currentEntryIndex = 0;
        Path filename = Path.of(path);
        String content = null;
        try {
            content = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] contentLines = content.split("\n");
        while (currentEntryIndex < elems) {
            entryArray[currentEntryIndex] = new MetalAndColorEntry();
            entryArray[currentEntryIndex].summary = extractStringList(contentLines[offset++]);
            entryArray[currentEntryIndex].elements = extractStringList(contentLines[offset++]);
            entryArray[currentEntryIndex].color = extractParameter(contentLines[offset++]);
            entryArray[currentEntryIndex].metal = extractParameter(contentLines[offset++]);
            entryArray[currentEntryIndex].vegetables = extractStringList(contentLines[offset++]);
            offset += 2;
            currentEntryIndex++;
        }
        return entryArray;
    }

    public static List<String> extractStringList(String line) {
        String arraySubstring = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
        return Arrays.asList(arraySubstring.split(", "));
    }

    public static String extractParameter(String line) {
        String[] halves = line.split(": ");
        return halves[1].substring(1, halves[1].length() - 3);
    }
}
