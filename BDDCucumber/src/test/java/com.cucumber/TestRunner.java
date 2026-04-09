package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
            features = "classpath:Features",
            glue = {"com.cucumber"},
            tags = "@Login",
            plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

    )
//public class TestRunner extends AbstractTestNGCucumberTests{
//
//    }

public class TestRunner extends AbstractTestNGCucumberTests {

//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
    }