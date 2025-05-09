package com.example.managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;
    private final String propertyFilePath = "src/test/resources/config/config.properties";

    public ConfigFileReader() {
        properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Configuration properties file not found at: " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("Application URL not specified in config file.");
    }

    public long getImplicitWait() {
        String wait = properties.getProperty("implicitWait");
        if (wait != null) return Long.parseLong(wait);
        else throw new RuntimeException("Implicit wait not specified in config file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("Browser not specified in config file.");
    }
}