package com.cucumber.commonBase;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    protected SoftAssert softAssert;
    public static Scenario scenario;

    public WebDriver browserLaunch(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            webDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            webDriver.set(new EdgeDriver());
        }

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return webDriver.get();
    }

    public String readPropertiesFile(String property) throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/config.properties");
        Properties prop = new Properties();
        prop.load(fileReader);
        return prop.getProperty(property);
    }
}