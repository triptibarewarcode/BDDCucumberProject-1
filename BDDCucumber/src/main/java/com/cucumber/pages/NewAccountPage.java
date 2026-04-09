package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage extends Base {

    WebDriverWait wait;
    LoginPage loginPage;
    // Locators
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By email = By.name("email");
    private final By password = By.name("password");
    private final By confirmPassword = By.name("passwordReConfirm");
    private final By createAccountButton = By.xpath("//button[text()='Create Account']");
    private final By successMessage = By.xpath("//h3[text()='Congratulations! Your account has been created.']");
    private final By errorMessage = By.xpath("//div[@class='space-bot']//b[contains(text(),'sorry')]");
    private final By genericAlert = By.cssSelector(".alert, .message");

    public NewAccountPage() {
        wait = new WebDriverWait(Base.getDriver(), java.time.Duration.ofSeconds(10));
        loginPage = new LoginPage();
    }

     public void clickCreateAccountButton() {
         driver.findElement(createAccountButton).click();
     }

    public void enterFirstName(String value) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void enterAccountDetails(String firstNameVal, String lastNameVal, String emailVal, String passwordVal, String confirmPasswordVal) {
        enterFirstName(firstNameVal);
        enterLastName(lastNameVal);
        enterEmail(emailVal);
        enterPassword(passwordVal);
        enterConfirmPassword(confirmPasswordVal);
    }

    public void submitAccountForm() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    public String getSuccessMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (TimeoutException e) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(genericAlert)).getText();
            } catch (TimeoutException ex) {
                return "";
            }
        }
    }
}