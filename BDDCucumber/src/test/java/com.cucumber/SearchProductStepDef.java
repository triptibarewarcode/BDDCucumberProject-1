package com.cucumber;

import com.cucumber.commonBase.Base;
import com.cucumber.pages.LoginPage;
import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SearchProductStepDef extends Base {
    WebDriverWait wait;
    LoginPage loginPage;
    SearchPage searchPage;
    public SearchProductStepDef(){
        wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
        searchPage = new SearchPage();
    }

    @Given("the user is on the Kapruka homepage")
    public void userIsOnHomepage() {
        loginPage.clickYourAccount();
        loginPage.enterEmail("patrickjane@gmail.com");
        loginPage.enterPassword("Xsdc#23jane45");
        loginPage.clickLoginButton();
    }
    @When("the user searches for {string}")
    public void userSearchesFor(String keyword) {
        searchPage.enterSearchItem(keyword);
        searchPage.clickSearchButton();
    }


    @Then("at least one result should contain {string}")
    public void atLeastOneResultShouldContain(String keyword) {
        softAssert.assertTrue(
                searchPage.titlesContain(keyword),
                "Expected at least one result with '" + keyword +
                        "' but got: " + searchPage.getProductTitles()
        );
        softAssert.assertAll();
    }
    // Uses allTitlesContain() — every result matches keyword
    @Then("all results should contain {string}")
    public void allResultsShouldContain(String keyword) {
        softAssert.assertTrue(
                searchPage.allTitlesContain(keyword),
                "Expected ALL results to contain '" + keyword +
                        "' but got: " + searchPage.getProductTitles()
        );
        softAssert.assertAll();
    }

    // Uses getResultCount() — checks at least one product appeared
    @Then("the results page should show products")
    public void resultPageShouldShowProducts() {
        int count = searchPage.getResultCount();
        softAssert.assertTrue(
                count > 0,
                "Expected at least 1 result but got: " + count
        );
        softAssert.assertAll();
    }

    // Uses isNoResultsDisplayed() — checks no-results message appeared
    @Then("no results should be displayed")
    public void noResultsShouldBeDisplayed() {
        softAssert.assertTrue(
                searchPage.isNoResultsDisplayed(),
                "Expected no results message but products were shown"
        );
        softAssert.assertAll();
    }
}
