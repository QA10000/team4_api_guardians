package com.lms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import com.lms.ObjectRepo.LoginService;
import com.lms.utils.TestContext;

public class LoginStep {

    private final LoginService loginService;

    public LoginStep(TestContext context) {
        this.loginService = new LoginService(context);
    }

    @Given("admin sets no Authorization to Bearer Token")
    public void admin_sets_no_Authorization_to_Bearer_Token() {

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

    @Then("Admin receives {int} bad request for invalid baseUrl")
    public void admin_receives_bad_request_for_invalif_baseurl(Integer expectedStatusCode) {
        loginService.assertInvalidrequestError(expectedStatusCode);
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

    @When("Admin calls POST Https method for forgot password with valid endpoint")
    public void admin_calls_post_https_method_for_forgot_password_with_valid_endpoint() {
        loginService.makeForgotPwdRequestWithMethod("POST");
    }

    @When("Admin calls POST Https method for forgot password with invalid endpoint")
    public void admin_calls_post_https_method_for_forgot_password_with_invalid_endpoint() {
        loginService.makeForgotPwdRequestWithMethod("POST");
    }

    @When("Admin calls POST Https method forgot passwordwith invalid content type")
    public void admin_calls_post_https_method_forgot_passwordwith_invalid_content_type() {
        loginService.makeForgotPwdRequestWithMethod("POST");
    }


    @Given("Admin sets authorization to bearer Token with token")
    public void Admin_sets_authorization_to_bearer_Token_with_token() {
        loginService.setAuthorizationBearer();
    }

    @Given("Admin creates request for logout for UserLogin test case {string}")
    public void Admin_creates_request_for_logout_for_UserLogin_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Get Https method with valid endpoint")
    public void Admin_calls_Get_Https_method_with_valid_endpoint() {
        loginService.makeLogoutRequest();
    }

    @Given("Admin creates request for logout without token for UserLogin test case {string}")
    public void Admin_creates_request_for_logout_without_token_for_UserLogin_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @Then("Admin receives {int} Not found")
    public void Admin_receives_Not_found(int expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @When("Admin calls Get Https method with invalid baseURL")
    public void Admin_calls_Get_Https_method_with_invalid_baseURL() {
        loginService.makeGetRequestWithInvalidBaseURL();
    }

    @Then("Admin receives {int} ok and response with {string}")
    public void Admin_receives_ok_and_response_with(int expectedStatusCode, String message) {
        loginService.assertStatusCodeWithMessage(expectedStatusCode, message);
    }

    @When("Admin calls Get Https method with invalid endpoint")
    public void Admin_calls_Get_Https_method_with_invalid_endpoint() {
        loginService.makeGetRequestWithInvalidEndpoint();
    }

    @Given("Admin creates request for logout after token expiration for UserLogin test case {string}")
    public void Admin_creates_request_for_logout_after_token_expiration_for_UserLogin_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls POST Https method with invalid endpoint")
    public void Admin_calls_POST_Https_method_with_invalid_endpoint() {
        loginService.makePostRequestWithInvalidEndpoint();
    }

    @Then("Admin receives {int} ok and response with {string} and true")
    public void Admin_receives_ok_and_response_with_and_true(int expectedStatusCode, String message) {
        loginService.assertStatusCodeWithMessageAndSuccess(expectedStatusCode, message);
    }

    @Given("Admin creaes request with valid email and new password for UserLogin test case {string}")
    public void Admin_creaes_request_with_valid_email_and_new_password_for_UserLogin_test_case(String testCaseId) {
        loginService.loadResetPasswordData(testCaseId);
    }

    @Given("Admin creaes request with valid email and old password for UserLogin test case {string}")
    public void Admin_creaes_request_with_valid_email_and_old_password_for_UserLogin_test_case(String testCaseId) {
        loginService.loadResetPasswordData(testCaseId);
    }

    @Then("Admin receives {int} Bad request response with {string}")
    public void Admin_receives_Bad_request_response_with(int expectedStatusCode, String message) {
        loginService.assertStatusCodeWithResponseMessage(expectedStatusCode, message);
    }

    @Given("Admin creaes request new password with invalid email for UserLogin test case {string}")
    public void Admin_creaes_request_new_password_with_invalid_email_for_UserLogin_test_case(String testCaseId) {
        loginService.loadResetPasswordData(testCaseId);
    }

    @Then("Admin receives {int} Method not Allowed")
    public void Admin_receives_Method_not_Allowed(int expectedStatusCode) {
        loginService.assertStatusCode(expectedStatusCode);
    }

    @When("Admin calls GET Https method with valid endpoint")
    public void Admin_calls_GET_Https_method_with_valid_endpoint() {
        loginService.makeLogoutRequest();
    }

    @Given("Admin creaes request with valid data and invalid content type for UserLogin test case {string}")
    public void Admin_creaes_request_with_valid_data_and_invalid_content_type_for_UserLogin_test_case(String testCaseId) {
        loginService.loadLoginData(testCaseId);
    }

    @When("Admin calls Post Https method with invalid baseURL")
    public void Admin_calls_Post_Https_method_with_invalid_baseURL() {
        loginService.makeRequestWithInvalidBaseURL();
    }

    @Given("Admin creaes request new password with special characters for UserLogin test case {string}")
    public void Admin_creaes_request_new_password_with_special_characters_for_UserLogin_test_case(String testCaseId) {
        loginService.loadResetPasswordData(testCaseId);
    }

    @Then("Admin receives {int} Not found for invalid baseUrl")
    public void Admin_receives_Not_found_for_invalid_baseUrl(int expectedStatusCode) {
        loginService.assertInvalidrequestError(expectedStatusCode);
    }
}
