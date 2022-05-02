package com.Automation.Tier2Test.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class StringLibrary {

    public String getRandomAphabets(int length) {
        String name = RandomStringUtils.randomAlphabetic(length).toLowerCase();
        return name;

    }

    public String getRandomEmail() {
        String email = getRandomAphabets(4)+"@"+getRandomAphabets(4)+".com";
        return email;

    }
}
