package com.epam.tc.hw7_jdi;

import com.epam.tc.hw7_jdi.entities.MetalsAndColorsEntry;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class JdiTestDataProvider {
    public static final String EXPECTED_USERNAME = "ROMAN IOVLEV";
    public static final String DATASET_PATH = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "testDataSet")
    public static Object[][] metalsAndColorsDataSet() throws IOException {
        return parse(DATASET_PATH);
    }

    public static Object[][] parse(String path) throws IOException {
        Gson gson = new Gson();
        Object[][] dataArray;
        Type type = new TypeToken<Map<String, MetalsAndColorsEntry>>() {}.getType();
        Map<String, MetalsAndColorsEntry> map = gson.fromJson(new JsonReader(new FileReader(path)), type);
        int i = 0;
        dataArray = new Object[map.size()][1];
        for (Map.Entry<String, MetalsAndColorsEntry> entry : map.entrySet()) {
            dataArray[i][0] = entry.getValue();
            i++;
        }
        return dataArray;
    }
}
