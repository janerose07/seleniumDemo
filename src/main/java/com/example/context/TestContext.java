package com.example.context;

import com.example.managers.ConfigFileReader;
import com.example.managers.DriverManager;
import com.example.managers.PageObjectManager;

public class TestContext {
    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    private final ConfigFileReader configFileReader;

    public TestContext() {
        driverManager = new DriverManager();
        configFileReader = new ConfigFileReader();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }
}