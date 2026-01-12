package com.lms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;

import com.lms.ObjectRepo.LoginService;
import com.lms.pojo.LoginRequest;
import com.lms.utils.TestContext;
import com.lms.utils.TokenManager;

public class LoginSteps {

    private final TestContext context;
    private final LoginService loginService;

    public LoginSteps(TestContext context) {
        this.context = context;
        this.loginService = new LoginService(context);
    }

    @Given("Admin creates request with valid credentials for UserLogin test case {string}")
    public void admin_creates_request(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Post Https method with valid endpoint")
    public void admin_posts_request() {
        LoginRequest login = new LoginRequest(context.getEmail(), context.getPassword());
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(login)
                .post(context.getEndPoint());

        context.setLastResponse(response);
        if (response.statusCode() == 200) {
            String token = response.jsonPath().getString("token");
            assertNotNull(token, "Token is missing in response");
            TokenManager.saveToken(token);
        }
    }

    @Then("Admin receives {int} created with auto generated token")
    public void admin_gets_token(Integer expectedStatusCode) {
        assertNotNull("No response captured", context.getLastResponse());
        assertEquals("Expected 200 on login", 200, context.getLastResponse().statusCode());
        assertTrue("Token not saved in TokenManager", TokenManager.hasToken());

    }

    @When("Admin calls GET Https method with post endpoint")
    public void admin_calls_get_https_method_with_post_endpoint() {
        LoginRequest login = new LoginRequest(context.getEmail(), context.getPassword());
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(login)
                .get(context.getEndPoint());
        context.setLastResponse(response);
    }

    @Then("Admin receives {int} method not allowed")
    public void admin_receives_method_not_allowed(Integer expectedStatusCode) {
    //    assertNotNull("No response captured", context.getLastResponse());
        assertEquals("Expected " + expectedStatusCode + " status code", 
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @When("Admin calls Post Https method with invalid base URL")
    public void admin_calls_post_https_method_with_invalid_base_url() {
        try {
            LoginRequest login = new LoginRequest(context.getEmail(), context.getPassword());
            String invalidEndpoint = "https://invalid-url-12345.com/lms" + context.getEndPoint();
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(login)
                    .post(invalidEndpoint);
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid base URL.");
    //        context.setLastResponse(null);
        }
    }

    @Then("Admin receives {int} bad request")
    public void admin_receives_bad_request(Integer expectedStatusCode) {
    //    assertNotNull("No response captured", context.getLastResponse());
        assertEquals("Expected " + expectedStatusCode + " status code", 
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @When("Admin calls Post Https method with invalid content type")
    public void admin_calls_post_https_method_with_invalid_content_type() {
        try {
            LoginRequest login = new LoginRequest(context.getEmail(), context.getPassword());
            Response response = RestAssured.given()
                    .contentType("application/xml")
                    .body(login)
                    .post(context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid content type.");
    //        context.setLastResponse(null);
        }
    }

    @Then("Admin receives {int} unsupported media type")
    public void admin_receives_unsupported_media_type(Integer expectedStatusCode) {
    //    assertNotNull("No response captured", context.getLastResponse());
        assertEquals("Expected " + expectedStatusCode + " status code", 
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }
}
