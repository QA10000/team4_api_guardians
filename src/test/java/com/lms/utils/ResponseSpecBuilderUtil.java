package com.lms.utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderUtil {

    public static ResponseSpecification defaultResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();
    }
}
