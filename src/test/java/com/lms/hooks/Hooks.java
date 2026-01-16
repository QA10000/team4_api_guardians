package com.lms.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.lms.utils.ConfigManager;
import com.lms.utils.TokenManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Hooks {

    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    public static ThreadLocal<Boolean> skipAuthFlag = new ThreadLocal<>();
    
    @Before
    public void setUp(Scenario scenario) {
        // Allure Reporting
        Allure.description("Scenario: " + scenario.getName());
        Allure.label("severity", "normal");
        
        // Extent Report
        ExtentCucumberAdapter.addTestStepLog("Starting scenario: " + scenario.getName());

        // Initialize skipAuthFlag to false for each scenario
        skipAuthFlag.set(false);

        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseUrl())
                .setRelaxedHTTPSValidation()
                .setContentType("application/json")
                .build();
    
        boolean skipAuth = scenario.getSourceTagNames().contains("@skipAuth");

        if (!skipAuth && TokenManager.hasToken()) {
            String token = TokenManager.getToken();
            spec = spec.header("Authorization", "Bearer " + token);
        } 
        
        RestAssured.requestSpecification = spec;

        // Set ThreadLocal so getRequest() works
        requestSpec.set(spec);
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Scenario Status", "text/plain", "FAILED: " + scenario.getName(), "txt");
        } else {
            Allure.addAttachment("Scenario Status", "text/plain", "PASSED: " + scenario.getName(), "txt");
        }
        
        if (scenario.isFailed()) {
            ExtentCucumberAdapter.addTestStepLog("Scenario Failed: " + scenario.getName());
        } else {
            ExtentCucumberAdapter.addTestStepLog("Scenario Passed: " + scenario.getName());
        }
        
        requestSpec.remove();
    }
    
    public static RequestSpecification getRequest() {
         return requestSpec.get();
    }
}
