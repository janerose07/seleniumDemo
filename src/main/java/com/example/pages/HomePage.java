package com.example.pages;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    // Locators
    //private final By welcomeMessage = By.id("welcome-message");
    private final By logoutButton = By.id("logout");
    private final By welcomeMessage = By.xpath("//span[contains(text(),'Sign up for a free account to ')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomeMessageDisplayed() {
        return isElementDisplayed(welcomeMessage);
    }

    public String getWelcomeMessage() {
        return getElementText(welcomeMessage);
    }

    public void clickLogout() {
        clickElement(logoutButton);
    }
}