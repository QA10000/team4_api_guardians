package com.lms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.Assert.*;

import com.lms.ObjectRepo.LoginService;
import com.lms.pojo.LoginRequest;
import com.lms.utils.RestAssuredUtil;
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
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                context.getEndPoint());
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
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), loginRequest,
                context.getEndPoint());
        context.setLastResponse(response);
    }

    @Then("Admin receives {int} method not allowed")
    public void admin_receives_method_not_allowed(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @When("Admin calls Post Https method with invalid base URL")
    public void admin_calls_post_https_method_with_invalid_base_url() {
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

    @Then("Admin receives {int} bad request")
    public void admin_receives_bad_request(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @When("Admin calls Post Https method with invalid content type")
    public void admin_calls_posthttps_method_with_invalid_content_type() {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        try {
            Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid content type.");
        }
    }

    @Then("Admin receives {int} unsupported media type")
    public void admin_receives_unsupported_media_type(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @Given("Admin creates request with valid credentials UserLogin test case {string}")
    public void admin_creates_request_with_valid_credentials_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Post Https method with invalid endpoint")
    public void admin_calls_post_https_mthod_with_invalid_endpoint() {
        LoginRequest loginRequest = new LoginRequest(context.getEmail(), context.getPassword());
        try {
            Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), loginRequest,
                    context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid endpoint.");
        }
    }

    @Then("Admin receives {int} unauthorized")
    public void admin_receives_unauthorized(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @Given("Admin creates request with special characters in admin email UserLogin test case {string}")
    public void admin_creates_request_with_special_characters_in_admin_email_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Then("Admin receives {int} with message {string} and false success message")
    public void admin_receives_with_message_and_false_success_message(Integer expectedStatusCode,
            String expectedMessage) {
        assertEquals("Expected " + expectedMessage + " message",
                expectedMessage, context.getLastResponse().getStatusLine());
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }

    @Given("Admin creates request with special characters in password UserLogin test case {string}")
    public void admin_creates_request_with_special_characters_in_password_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with numbers in email UserLogin test case {string}")
    public void admin_creates_request_with_numbers_in_email_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with numbers in password UserLogin test case {string}")
    public void admin_creates_request_with_numbers_in_password_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with Null password UserLogin test case {string}")
    public void admin_creates_request_with_null_password_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with Null email UserLogin test case {string}")
    public void admin_creates_request_with_null_email_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with Null body UserLogin test case {string}")
    public void admin_creates_request_with_null_body_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Post Https method with valid endpoint and null body")
    public void admin_calls_post_https_method_with_valid_endpoint_and_null_body() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .post(context.getEndPoint());
            context.setLastResponse(response);
        } catch (Exception e) {
            System.out.println("Error: Failed to call POST HTTPS method with invalid content type.");
        }
    }

    @Then("Admin receives {int} Bad request")
    public void admin_receives_badrequest(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }
}
