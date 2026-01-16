package com.lms.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import com.lms.utils.ConfigManager;
import com.lms.utils.TokenManager;

public class Hooks {

    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    
    @Before
    public void setUp(Scenario scenario) {

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
    
    public static RequestSpecification getRequest() {
         return requestSpec.get();
    }
}
