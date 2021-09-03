package com.epam.tc.hw5.cucumber;

import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private String number;
    private String name;
    private String description;

    public User(String number, String name, String description) {
        this.number = number;
        this.name = name;
        if (description.endsWith("some description")) {
            description = description.replace(" some description", "\nsome description");
        }
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<User> getUserListFromDataTable(DataTable table) {
        List<User> userList = new ArrayList<>();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            userList.add(new User(columns.get("Number"), columns.get("User"), columns.get("Description")));
        }
        return userList;
    }

    @Override
    public String toString() {
        return String.format("No: %s\nName: %s\nDescription: %s", this.getNumber(), this.getName(),
            this.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        User u = (User) o;
        return (this.getNumber().equals(u.getNumber())
                && this.getName().equals(u.getName())
                && this.getDescription().equals(u.getDescription()));
    }

}
