package com.epam.tc.hw7_jdi;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass<User> {
    public static final User ROMAN = new User("Roman", "Jdi1234");

    public String name;
    public String password;
}
