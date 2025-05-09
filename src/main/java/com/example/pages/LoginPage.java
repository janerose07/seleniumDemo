package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.className("error-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}