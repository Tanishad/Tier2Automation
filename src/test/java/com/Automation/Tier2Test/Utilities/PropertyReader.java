package com.Automation.Tier2Test.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties prop;

    public Properties getDefaultPropertyFileObject() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/com.Automation.Tier2Test/TestData/testData.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}