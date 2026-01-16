package com.lms.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"com.lms.hooks", "com.lms.stepdefinitions"},
	    plugin = {
	    		"pretty",
	    		"html:target/cucumber-reports.html",
	    		"json:target/cucumber-reports/cucumber.json",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	    		},
		monochrome = true,
		dryRun = false
			)
public class TestRunner {
}
