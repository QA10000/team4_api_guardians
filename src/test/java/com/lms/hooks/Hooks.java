package com.lms.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import com.lms.utils.ConfigManager;
import com.lms.utils.SesionManager;

public class Hooks {

    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    
    @Before
    public void setUp(Scenario scenario) {

<<<<<<< HEAD
        request = given()
                .baseUri(ConfigManager.get("baseUrl"))
                .header("Content-Type", "application/json");
        requestSpec.set(request);
    }
    public static RequestSpecification getRequest() {
        return requestSpec.get();
=======
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri(ConfigManager.get("baseUrl"))
                .setRelaxedHTTPSValidation()
                .setContentType("application/json")
                .build();
    
        boolean skipAuth = scenario.getSourceTagNames().contains("@skipAuth");

        if (!skipAuth && SesionManager.hasToken()) {
            String token = SesionManager.getToken();
            spec = spec.header("Authorization", "Bearer " + token);
        }
        
        RestAssured.requestSpecification = spec;

    // Set ThreadLocal so getRequest() works
        requestSpec.set(spec);
>>>>>>> a4432e90949ac4c7d5b091ac6a2ff6606828a1cd
    }
    
    // public static RequestSpecification getRequest() {
    //     return requestSpec.get();
    // }
}
