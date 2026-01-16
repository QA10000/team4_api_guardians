package com.lms.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtil {

    public static Response makeRequest(String method, String contentType, Object body, String endpoint) {
        var req = RestAssured.given();
        if (contentType != null && !contentType.isEmpty()) {
            req = req.contentType(contentType);
        }
        if (body != null) {
            req = req.body(body);
        }
        if (method.equalsIgnoreCase("POST")) {
            return req.post(endpoint);
        } else if (method.equalsIgnoreCase("GET")) {
            return req.get(endpoint);
        } else if (method.equalsIgnoreCase("PUT")) {
            return req.put(endpoint);
        } else if (method.equalsIgnoreCase("PATCH")) {
            return req.patch(endpoint);
        } else if (method.equalsIgnoreCase("DELETE")) {
            return req.delete(endpoint);
        } else {
            throw new IllegalArgumentException("HTTP method not supported: " + method);
        }
    }
}
