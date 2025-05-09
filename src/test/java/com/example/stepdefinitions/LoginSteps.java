package com.example.stepdefinitions;

import com.example.context.TestContext;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private final TestContext testContext;
    private final LoginPage loginPage;
    private final HomePage homePage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        loginPage.navigateToLoginPage(testContext.getConfigFileReader().getApplicationUrl());
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be navigated to home page")
    public void userShouldBeNavigatedToHomePage() {
        Assert.assertTrue("User is not navigated to home page", homePage.isWelcomeMessageDisplayed());
    }

    @Then("welcome message should be displayed")
    public void welcomeMessageShouldBeDisplayed() {
        String actualMessage = homePage.getWelcomeMessage();
        Assert.assertTrue("Welcome message is not displayed correctly",
                actualMessage.contains("Welcome"));
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue("Error message is not displayed", loginPage.isErrorMessageDisplayed());
    }
}