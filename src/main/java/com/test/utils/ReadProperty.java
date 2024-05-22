package com.test.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {

    public static String getValue(String key) {
        FileInputStream fileInputStream;
        Properties prop = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/resources/config.property");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
        }
        return prop.getProperty(key);
    }
}
