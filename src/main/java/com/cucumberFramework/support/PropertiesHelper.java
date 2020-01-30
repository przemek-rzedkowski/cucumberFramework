package com.cucumberFramework.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    public static Properties properties;

    public static void loadConfigurationProperties() throws IOException {
        properties = new Properties();
        InputStream propertiesFileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        if (propertiesFileInputStream != null) {
            properties.load(propertiesFileInputStream);
        }
        properties.putAll(System.getProperties());
    }
}
