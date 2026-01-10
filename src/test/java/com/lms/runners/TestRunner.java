package com.lms.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features", // Location of the feature files
	    glue = {"com.lms.hooks", "com.lms.stepdefinitions"}, // Location of the step definition classes
	    plugin = {"pretty", "html:target/cucumber-reports.html"
	    		}
			)
public class TestRunner {
}
