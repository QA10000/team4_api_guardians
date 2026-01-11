package com.lms.hooks;

import com.lms.utils.ConfigManager;
import io.cucumber.java.Before;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Hooks {

    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    @Before
    public void setUp() {

        request = given()
                .baseUri(ConfigManager.get("baseUrl"))
                .header("Authorization", "Bearer " + ConfigManager.get("token"))
                .header("Content-Type", "application/json");
        requestSpec.set(request);
    }
    public static RequestSpecification getRequest() {
        return requestSpec.get();
    }
}


