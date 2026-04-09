package com.cucumber.commonServices;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    public static WebDriverWait getWait() {
        return new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
    }

    public static WebElement visibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static WebElement presence(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Alert waitForAlert() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }
}