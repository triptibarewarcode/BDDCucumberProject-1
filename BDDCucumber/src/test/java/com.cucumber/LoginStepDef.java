package com.cucumber;

import com.cucumber.commonBase.Base;
import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import javax.swing.*;
import java.time.Duration;
import java.util.Random;

public class LoginStepDef extends Base{


     WebDriverWait wait;
     LoginPage loginPage;

    public LoginStepDef(){
         wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
    }

    // ── Given ────────────────────────────────────────────────────────────────

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {

            loginPage.clickYourAccount();
    }

    // ── When ─────────────────────────────────────────────────────────────────

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {


        loginPage.enterEmail(username);
    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {

       loginPage.enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {

        loginPage.clickLoginButton();
    }

    // ── Then ─────────────────────────────────────────────────────────────────


    @Then("the system should display {string}")
    public void theSystemShouldDisplayExpectedResult(String expectedResult) {

        String actualTitle = loginPage.getTitle();
        String actualError = loginPage.getErrorMessage();

        boolean isDashboard = expectedResult.equalsIgnoreCase("dashboard");

        if (isDashboard) {
            softAssert.assertTrue(
                    actualTitle != null && actualTitle.contains("Your Account"),
                    "Expected user to land on Dashboard, but title was: " + actualTitle
            );
        } else {
            softAssert.assertTrue(
                    actualError != null && actualError.contains(expectedResult),
                    "Expected error message: '" + expectedResult + "' but found: " + actualError
            );
        }

        softAssert.assertAll();
    }


}