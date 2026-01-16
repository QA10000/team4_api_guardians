package com.lms.ObjectRepo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lms.pojo.LoginRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import com.lms.utils.RestAssuredUtil;
import com.lms.utils.TestContext;
import com.lms.utils.TokenManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginService {
    private final TestContext context;

    public LoginService(TestContext context) {
        this.context = context;
    }

    public void loadLoginData(String testCaseId) {

        String filepath = ConfigManager.get("testData");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath, "UserLogin", testCaseId);

        context.setEmail(loginData.get("Email"));
        context.setPassword(loginData.get("Password"));
        context.setEndPoint(loginData.get("Endpoint"));
        context.setContentType(loginData.get("ContentType"));
        context.setExpectedStatus(loginData.get("ExpectedStatus"));
    }

    public void makeRequest() {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                context.getEndPoint());
        context.setLastResponse(response);
    }

    public void saveToken() {
        if (context.getLastResponse().statusCode() == 200) {
            String token = context.getLastResponse().jsonPath().getString("token");
            assertNotNull(token, "Token is missing in response");
            TokenManager.saveToken(token);
        }
    }

    public void makeRequestAndSaveToken() {
        makeRequest();
        saveToken();
    }

    public void makeRequestWithMethod(String method) {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        try {
            Response response = RestAssuredUtil.makeRequest(method, context.getContentType(), loginRequest,
                    context.getEndPoint());

                    System.out.println("Response is : " +response.asString());

            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call " + method + " HTTPS method.");
            context.setLastResponse(null);
        }
    }

    public void makeRequestWithInvalidBaseURL() {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        try {
            String invalidEndpoint = "https://invalid-url-12345.com/lms" + context.getEndPoint();
            Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                    invalidEndpoint);
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid base URL.");
        }
    }

    public void makeRequestWithNullBody() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .post(context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with null body.");
        }
    }

    public void assertStatusCode(Integer expectedStatusCode) {
        assertNotNull("Response should not be null", context.getLastResponse());
        System.out.println("Response is "+context.getLastResponse().getBody());
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    public void assertTokenGenerated() {
        assertNotNull("No response captured", context.getLastResponse());
        assertEquals("Expected 200 on login", 200, context.getLastResponse().statusCode());
        assertTrue("Token not saved in TokenManager", TokenManager.hasToken());
    }

    public void assertStatusCodeWithMessage(Integer expectedStatusCode, String expectedMessage) {
        assertNotNull("Response should not be null", context.getLastResponse());
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
        // Try to extract message from JSON body first, otherwise use error message
        String actualMessage = context.getLastResponse().jsonPath().getString("message");
        if (actualMessage == null || actualMessage.isEmpty()) {
            actualMessage = context.getLastResponse().jsonPath().getString("error");
        }
        assertEquals("Expected " + expectedMessage + " message",
                expectedMessage, actualMessage);
    }

    public void assertStatusCodeWithJsonMessage(Integer expectedStatusCode, String message) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
        assertEquals("Expected message", message, context.getLastResponse().jsonPath().getString("message"));
    }

    public void makeForgotPwdRequestWithMethod(String method) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserLoginEmailId(context.getEmail());
        try {
            Response response = RestAssuredUtil.makeRequest(method, context.getContentType(), loginRequest,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call " + method + " HTTPS method.");
            context.setLastResponse(null);
        }
    }

    public void setAuthorizationBearer() {
        if (TokenManager.hasToken()) {
            String token = TokenManager.getToken();

        }
    }

    public void makeLogoutRequest() {
        try {
            Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), null,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call GET HTTPS method for logout.");
        }
    }

    public void makeGetRequestWithInvalidBaseURL() {
        try {
            String invalidEndpoint = "https://invalid-url-12345.com/lms" + context.getEndPoint();
            Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), null,
                    invalidEndpoint);
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call GET HTTPS method with invalid base URL.");
        }
    }

    public void makeGetRequestWithInvalidEndpoint() {
        try {
            Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), null,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call GET HTTPS method with invalid endpoint.");
        }
    }

    public void loadResetPasswordData(String testCaseId) {
        String filepath = ConfigManager.get("testData");
        Map<String, String> loginData = ExcelReader.getRowByTestCaseId(filepath, "UserLogin", testCaseId);

        context.setEmail(loginData.get("Email"));
        context.setPassword(loginData.get("Password"));
        context.setEndPoint(loginData.get("Endpoint"));
        context.setContentType(loginData.get("ContentType"));
        context.setExpectedStatus(loginData.get("ExpectedStatus"));
    }

    public void makePostRequestWithInvalidEndpoint() {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        try {
            Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid endpoint.");
        }
    }

    public void assertStatusCodeWithMessageAndSuccess(Integer expectedStatusCode, String expectedMessage) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
        assertEquals("Expected message", expectedMessage, context.getLastResponse().jsonPath().getString("message"));
        assertTrue("Expected success to be true", context.getLastResponse().jsonPath().getBoolean("success"));
    }

    public void assertStatusCodeWithResponseMessage(Integer expectedStatusCode, String expectedMessage) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
        assertEquals("Expected message in response", expectedMessage, context.getLastResponse().jsonPath().getString("message"));
    }

    public void assertInvalidrequestError(Integer expectedStatusCode) throws AssertionError {
        // For invalid base URL, we expect the request to fail or return an error
        // If response is null, that means the request failed (which is expected)
        if (context.getLastResponse() == null) {
            // This is expected - invalid URL should cause connection error
            return;
        }
        // If we do get a response, check the status code
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }
}
