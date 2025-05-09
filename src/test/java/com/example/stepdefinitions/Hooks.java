package com.example.stepdefinitions;

import com.example.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final TestContext testContext;
    private WebDriver driver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp() {
        driver = testContext.getDriverManager().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot if scenario fails
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        testContext.getDriverManager().closeDriver();
    }
}