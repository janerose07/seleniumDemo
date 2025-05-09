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

    @When("user clicks on schema button")
    public void userClicksOnLoginButton()   {
        loginPage.clickSchemaButton();
    }


    @Then("user should be navigated to home page")
    public void userShouldBeNavigatedToHomePage()   {
        Assert.assertTrue("User is not navigated to home page", homePage.isWelcomeMessageDisplayed());
    }

}