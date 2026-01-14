package com.lms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.lms.ObjectRepo.LoginService;
import com.lms.utils.TestContext;

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
        loginService.makeRequestAndSaveToken();
    }

    @Then("Admin receives {int} created with auto generated token")
    public void admin_gets_token(Integer expectedStatusCode) {
        loginService.assertTokenGenerated();
    }

    @When("Admin calls GET Https method with post endpoint")
    public void admin_calls_get_https_method_with_post_endpoint() {
        loginService.makeRequestWithMethod("GET");
    }

    @Then("Admin receives {int} method not allowed")
    public void admin_receives_method_not_allowed(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @When("Admin calls Post Https method with invalid base URL")
    public void admin_calls_post_https_method_with_invalid_base_url() {
        loginService.makeRequestWithInvalidBaseURL();
    }

    @Then("Admin receives {int} bad request")
    public void admin_receives_bad_request(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @When("Admin calls Post Https method with invalid content type")
    public void admin_calls_posthttps_method_with_invalid_content_type() {
        loginService.makeRequestWithMethod("POST");
    }

    @Then("Admin receives {int} unsupported media type")
    public void admin_receives_unsupported_media_type(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @Given("Admin creates request with valid credentials UserLogin test case {string}")
    public void admin_creates_request_with_valid_credentials_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Post Https method with invalid endpoint")
    public void admin_calls_post_https_mthod_with_invalid_endpoint() {
        loginService.makeRequestWithMethod("POST");
    }

    @Then("Admin receives {int} unauthorized")
    public void admin_receives_unauthorized(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @Given("Admin creates request with special characters in admin email UserLogin test case {string}")
    public void admin_creates_request_with_special_characters_in_admin_email_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Then("Admin receives {int} with message {string} and false success message")
    public void admin_receives_with_message_and_false_success_message(Integer expectedStatusCode,
            String expectedMessage) {
        loginService.assertStatusCodeWithMessage(expectedStatusCode, expectedMessage);
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
        loginService.makeRequestWithNullBody();
    }

    @Then("Admin receives {int} Bad request")
    public void admin_receives_badrequest(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @Given("Admin creates request with invalid credentials for UserLogin test case {string}")
    public void admin_creates_request_with_invalid_credentials_for_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Given("Admin creates request with special character email for UserLogin test case {string}")
    public void admin_creates_request_with_special_character_email_for_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls POST Https method with valid endpoint")
    public void admin_calls_pos_https_method_with_valid_endpoint() {
        loginService.makeRequestWithMethod("POST");
    }

    @When("Admin calls POST Https method with invalid endpoint")
    public void admin_calls_post_https_method_with_invalid_endpoint() {
        loginService.makeRequestWithMethod("POST");
    }

    @Then("Admin receives {int} not found")
    public void admin_receives_not_found(Integer expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @Given("Admin creates request with null body for UserLogin test case {string}")
    public void admin_creates_request_with_null_body_for_user_login_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Then("Admin receives {int} with message {string}")
    public void admin_receives_with_message(Integer expectedStatusCode, String message) {
        loginService.assertStatusCodeWithJsonMessage(expectedStatusCode, message);
    }

    @When("Admin calls POST Https method with invalid content type")
    public void admin_calls_post_https_method_with_invalid_content_type() {
        loginService.makeRequestWithMethod("POST");
    }

}
