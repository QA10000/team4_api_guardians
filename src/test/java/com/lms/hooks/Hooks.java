package com.lms.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import com.lms.utils.RequestSpecBuilderUtil;
import com.lms.utils.ResponseSpecBuilderUtil;
import com.lms.utils.TokenManager;

public class Hooks {

    public static RequestSpecification request;
    private static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    
    @Before
    public void setUp(Scenario scenario) {
        RequestSpecification spec = RequestSpecBuilderUtil.defaultRequestSpec();
    //     if (scenario.getSourceTagNames().contains("@skipAuth")) {
    //     return;
    // }  else {      
        if (TokenManager.hasToken()) {
            String token = TokenManager.getToken();
            spec = spec.header("Authorization", "Bearer " + token);
        }
        
        RestAssured.requestSpecification = spec;
        RestAssured.responseSpecification = ResponseSpecBuilderUtil.defaultResponseSpec();
    }
    
   
}


