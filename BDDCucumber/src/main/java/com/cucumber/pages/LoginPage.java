package com.cucumber.pages;


import com.cucumber.commonBase.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends Base {


    WebDriverWait wait;

    public LoginPage() {
        wait = new WebDriverWait(Base.getDriver(), java.time.Duration.ofSeconds(10));
    }

    private final By accountButton = By.className("myaccountblock");
    private final By email = By.name("email");

    private final By password = By.name("password");

    private final By login = By.xpath("//input[@name='Login' and @type='submit']");

    private final By ERROR_MSG = By.xpath("//div[@class='alert-danger fade in']");
    public void enterEmail(String username)
    {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(username);
    }

    public void enterPassword(String password1)
    {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(password1);
    }
    public void clickYourAccount()  {

        driver.findElement(accountButton).click();

    }

    public void clickLoginButton()
    {
        driver.findElement(login).click();

    }
    public String getTitle() {

        return driver.getTitle();
    }

    public String getErrorMessage() {

        try {
            return wait.until(ExpectedConditions
                            .visibilityOfElementLocated(ERROR_MSG))
                    .getText();
        } catch (TimeoutException e) {
            return ""; // no error = valid for happy path
        }
    }

    public String getOutcome() {

        if (getTitle()=="Your Account") {
            return "dashboard";
        }

        if (getErrorMessage() != null && !getErrorMessage().isEmpty()) return "error";

        // Neither appeared after both waits — something unexpected happened
        return "error";
    }
}
