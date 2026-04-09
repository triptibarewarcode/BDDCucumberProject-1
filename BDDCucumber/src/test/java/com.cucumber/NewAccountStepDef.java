package com.cucumber;

import com.cucumber.commonBase.Base;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.NewAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class NewAccountStepDef extends Base {

    NewAccountPage newAccountPage;
    LoginPage loginPage;

    public NewAccountStepDef() {
        loginPage = new LoginPage();
        newAccountPage = new NewAccountPage();
        softAssert = new SoftAssert();
    }

    @Given("User Navigate to LogIn Page")
    public void user_navigate_to_login_page() {
        loginPage.clickYourAccount();
    }

    @When("User clicks on New Account Button")
    public void user_clicks_on_new_account_button() {
        newAccountPage.clickCreateAccountButton();
    }

    @When("User enters Account details {string},{string},{string},{string},{string}")
    public void user_enters_account_details(String firstName,
                                            String lastName,
                                            String email,
                                            String password,
                                            String confirmPassword) {
        newAccountPage.enterAccountDetails(firstName, lastName, email, password, confirmPassword);
    }

    @Then("System should display {string}")
    public void system_should_display(String expectedOutcome) {
        newAccountPage.submitAccountForm();

        String actualMessage = newAccountPage.getSuccessMessage();
        if (actualMessage.isEmpty()) {
            actualMessage = newAccountPage.getErrorMessage();
        }

        softAssert.assertTrue(
                actualMessage.contains(expectedOutcome),
                "Expected outcome: '" + expectedOutcome + "' but got: '" + actualMessage + "'"
        );
        softAssert.assertAll();

        driver.quit();
    }
}