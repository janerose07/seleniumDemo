package com.example.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;
    private static final String CHROME_BROWSER = "chrome";
    private static final String FIREFOX_BROWSER = "firefox";
    private static final String EDGE_BROWSER = "edge";
    private static final String SAFARI_BROWSER = "safari";

    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        String browser = System.getProperty("browser", CHROME_BROWSER).toLowerCase();
        
        switch (browser) {
            case FIREFOX_BROWSER:
                WebDriverManager.firefoxdriver().setup();  // This auto-matches Chrome version
                driver = new FirefoxDriver();
                break;
            case EDGE_BROWSER:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI_BROWSER:
                driver = new SafariDriver();
                break;
            case CHROME_BROWSER:
            default:
            WebDriverManager.chromedriver().clearResolutionCache().forceDownload().setup();  // This auto-matches Chrome version
                driver = new ChromeDriver();
                break;
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}