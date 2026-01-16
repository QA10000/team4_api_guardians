package com.lms.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.lms.ObjectRepo.UserService;
import com.lms.utils.TestContext;

public class UserStep {

	private final TestContext context;
	private final UserService objUserService;
	private static final Logger logger = LogManager.getLogger(UserStep.class);

	public UserStep(TestContext context) {

		this.context = context;
		this.objUserService = new UserService(context);
	}

	@Given("Admin creates POST Request for new user with the LMS API endpoint test case {string}")
	public void admin_creates_post_request_for_new_user_with_the_lms_api_endpoint_test_case(String testCaseId) {

		objUserService.loadUserData(testCaseId);
	}
	@When("Admin sends HTTPS Request and request Body")
	public void admin_sends_https_request_and_request_body() {
		objUserService.postUserRequest();
	}
	
	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer expectedStatusCode) {

		objUserService.assertStatusCode(expectedStatusCode);  
	}
	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer expectedStatusCode) {
		objUserService.assertStatusCode(expectedStatusCode);
	}
	
	
	@When("Admin sends HTTPS Request")
	public void admin_sends_https_request() {
		objUserService.getAllUserRequest();
	}
	
	@Given("Admin creates GET Request test case {string}")
	public void admin_creates_get_request_test_case(String testCaseId) {
	   
	    objUserService.loadUserData(testCaseId);
	}
	@When("Admin sends HTTPS Request with admin ID")
	public void admin_sends_https_request_with_admin_id() {
		objUserService.getUser_ByUserId();
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer expectedStatusCode) {
		objUserService.assertStatusCode(expectedStatusCode);
	}
	@When("Admin sends HTTPS Request to get user with program ID    #\\(Mandatory : program Id, batch Id ,role id, admin id, admin role program batch status)")
	public void admin_sends_https_request_to_get_user_with_program_id_mandatory_program_id_batch_id_role_id_admin_id_admin_role_program_batch_status() {
	    
	}
	@When("Admin sends HTTPS Request with admin ID with invalid admin ID")
	public void admin_sends_https_request_with_admin_id_with_invalid_admin_id() {
		objUserService.getUser_ByInvalidUserId();
	}
	@When("Admin sends HTTPS Request to get all staff")
	public void admin_sends_https_request_to_get_all_staff() {
		objUserService.getAllStaffRequest();
	}
	@When("Admin sends HTTPS Request to get all user with role")
	public void admin_sends_https_request_to_get_all_user_with_role() {
		objUserService.getAllUser_withRole();
	}
	
	
	
/*  put op */
	
	@Given("Admin creates PUT Request {string}")
	public void admin_creates_put_request(String testCaseId) {
		 objUserService.loadUserData(testCaseId);
	}
	
	@When("Admin sends HTTPS Request and request Body with mandatory and additional fields")
	public void admin_sends_https_request_and_request_body_with_mandatory_and_additional_fields() {
		objUserService.putUserRequest_ByUserId();
	}
	@When("Admin sends HTTPS Request and request Body with invalid admin Id")
	public void admin_sends_https_request_and_request_body_with_invalid_admin_id() {
		objUserService.putUser_ByInvalidUserId();
	}
	
	@When("Admin sends HTTPS Request and request Body with invalid user Id")
	public void admin_sends_https_request_and_request_body_with_invalid_user_id() {
		objUserService.putUser_ByInvalidUserId();
	}
	
	@When("Admin sends HTTPS Request  and request Body  \\(missing mandatory fields)")
	public void admin_sends_https_request_and_request_body_missing_mandatory_fields() {
		objUserService.putUserRequest_ByUserId();
	}
	@When("Admin sends HTTPS Request and request Body with mandatory fields")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields() {
		objUserService.putUserRequest_ByProgramId();
	}

	@When("Admin sends HTTPS Request and request Body with invalid urser Id      #\\(Mandatory : Role ID and Role status)")
	public void admin_sends_https_request_and_request_body_with_invalid_urser_id_mandatory_role_id_and_role_status() {
		objUserService.putUserRequest_ByRoleId();
	}

	@When("Admin sends HTTPS Request and request Body with mandatory fields                 #\\(Mandatory : Role ID and Role status)")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields_mandatory_role_id_and_role_status() {
		objUserService.putUserRequest_ByRoleId();
	}

	@Then("Admin receives {int} Ok Status with response message  {string}")
	public void admin_receives_ok_status_with_response_message(Integer expectedstatus, String expectedmsg) {
		objUserService.assertStatusCodeWithMessage(expectedstatus, expectedmsg);
	}

	
	

	

	



}