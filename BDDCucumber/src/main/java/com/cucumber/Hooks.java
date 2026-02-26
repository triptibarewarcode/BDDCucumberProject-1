package com.cucumber;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonBase.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends Base

{
    //public static WebDriver driver;
    public static Scenario scenario;

    @Before
    public void setUp(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
        String browserIs = readPropertiesFile("browser");
        String URL = readPropertiesFile("URL");

        System.out.println("Browser Name: "+browserIs);
        driver = browserLaunch(browserIs);
        driver.manage().window().maximize();



    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTest currentStep = ExtentCucumberAdapter.getCurrentStep();
            if (currentStep != null) {
                currentStep.fail("Test failed: " + scenario.getName());
            } else {
                System.out.println("Warning: ExtentTest is null, failed step could not be logged.");
            }
        }
        driver.close();
        driver.quit();
    }
}

