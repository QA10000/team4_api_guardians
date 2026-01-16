package com.lms.hooks;

import com.lms.utils.ConfigManager;
import com.lms.utils.TokenManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Hooks {


    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {

<<<<<<< HEAD
<<<<<<< HEAD
        request = given()
                .baseUri(ConfigManager.get("baseUrl"))
                .header("Content-Type", "application/json");
        requestSpec.set(request);
    }
    public static RequestSpecification getRequest() {
        return requestSpec.get();
=======
=======
>>>>>>> f72151f04c86332c7a816e2b3c0d2e3a238af43b
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
<<<<<<< HEAD
>>>>>>> a4432e90949ac4c7d5b091ac6a2ff6606828a1cd
=======
>>>>>>> f72151f04c86332c7a816e2b3c0d2e3a238af43b
    }

    public static RequestSpecification getRequest() {
        return requestSpec.get();
    }

}


