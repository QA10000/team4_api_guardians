package com.lms.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lms.ObjectRepo.ProgramModule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ProgramModuleStep_Nishi {
	private ProgramModule programModule;
	private static final Logger logger = LogManager.getLogger(ProgramModuleStep_Nishi.class);
	Response response;
	String endpoint;
	String requestBody;

	public ProgramModuleStep_Nishi() {
		programModule = new ProgramModule();
	}

	@Given("Admin creates POST Request for the LMS with request body for program module")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_program_module() {
		programModule.prepareRequest("CreateProgram");

	}

	@When("Admin sends HTTPS Request and request Body with endpoint for program module")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module() {
		programModule.assertStatusCode(201);
		programModule.sendGetProgramRequest();
	}

	@Then("Admin receives {int} Created Status with response body for program module")
	public void admin_receives_created_status_with_response_body_for_program_module(Integer int1) {
		programModule.validateResponseCode(0);
		logger.info("user gets 201 status for successful program creation ");

	}

	@Given("Admin creates POST Request for the LMS with request body for program module without authorization")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_program_module_without_authorization() {
		programModule.prepareRequest("CreateProgramWitoutAuthoriztion");

	}

	@When("Admin sends HTTPS Request and  request Body with endpoint for program module") // it is a duplicated method
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module_prog() {
		programModule.sendGetProgramRequest();
	}

	@Then("Admin receives {int} Unauthorized for program module for program module")
	public void admin_receives_unauthorized_for_program_module_for_program_module(Integer int1) {
		programModule.validateResponseCode(401);;
		logger.info("user gets 401 status");

	}

	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() {
		programModule.prepareRequest("CreateProgramWithValidLengthProgramDescription");

	}

	@When("Admin sends HTTPS Request and  request Body with endpoint for program module with valid description")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module_with_valid_description() {
		programModule.sendGetProgramRequest();

	}

	@Then("Admin receives {int} Created Status with response body for program module for valid description")
	public void admin_receives_created_status_with_response_body_for_program_module_for_valid_description(
			Integer int1) {
		programModule.validateResponseWithUpdatedValues(201, null);

	}// third scenario

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		programModule.sendGetProgramRequest();
	}

	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		programModule.validateResponseWithUpdatedValues(201, endpoint);
	}

	@Then("Admin receives {int} Method Not Allowed")
	public void admin_receives_method_not_allowed(Integer int1) {
		logger.info("User gets error message for method not allowed");
		programModule.validateResponseCode(405);
		;
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
		logger.info("User gets error message for not found");
		programModule.validateResponseCode(404);
		;
	}

	@Given("Admin creates POST Request for the LMS with invalid request body for program")
	public void admin_creates_post_request_for_the_lms_with_invalid_request_body_for_program() {
		programModule.prepareRequest("CreateProgramInvalidBody");
	}

	@Then("Admin receives {int} ok")
	public void admin_receives_ok(Integer int1) {
		logger.info("User gets 201 for successfull program creation");
		programModule.validateSuccessResponse(201);
	}

	@Then("Admin receives {int} not found  Status with error message")
	public void admin_receives_not_found_status_with_error_message(Integer int1) {
		logger.info("User gets error message for not found");
		programModule.validateResponseCode(404);
	}

	@Then("Admin receives {int} Status with response body as Unauthorized")
	public void admin_receives_status_with_response_body_as_unauthorized(Integer int1) {
		logger.info("User gets error message for unauthorized access");
		programModule.validateResponseCode(401);
	}

	@Then("Admin receives {int} Unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		logger.info("User gets error message for unauthorized access");
		programModule.validateResponseCode(401);

	}

	@Given("Admin creates PUT Request for the LMS API  with missing mandatory fields")
	public void admin_creates_put_request_for_the_lms_api_with_missing_mandatory_fields() {
		programModule.prepareRequest("UpdateProgramWithoutRequestBody");
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() {
		programModule.sendGetProgramRequest();
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
		programModule.prepareRequest("UpdateProgramValidProgramIDValidRequestBody");
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body() {
		programModule.prepareRequest("UpdateProgramValidProgramIDValidRequestBody");
	}

	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {
		programModule.prepareRequest("RetrieveProgramValidID");
	}

	@Given("Admin creates GET Request for the LMS API for valid id")
	public void admin_creates_get_request_for_the_lms_api_for_valid_id() {
		programModule.prepareRequest("RetrieveProgramValidID");
	}

	@Given("Admin creates GET Request for the LMS API for invalid id")
	public void admin_creates_get_request_for_the_lms_api_for_invalid_id() {
		programModule.prepareRequest("RetrieveProgramInvalidID");
	}

	@Given("Admin creates GET Request for the LMS API for invalid baseURI")
	public void admin_creates_get_request_for_the_lms_api_for_invalid_base_uri() {
		programModule.prepareRequest("RetrieveProgramByInvalidBaseURIByID");
	}

	@Given("Admin creates GET Request for the LMS API for without Authorization")
	public void admin_creates_get_request_for_the_lms_api_for_without_authorization() {
		programModule.prepareRequest("RetrieveProgramValidIDWithoutAuthorization");
	}

	@Given("Admin creates GET Request for the LMS API for Invalid Endpoint")
	public void admin_creates_get_request_for_the_lms_api_for_invalid_endpoint() {
		programModule.prepareRequest("RetrieveProgramvalidIDInvalidEndpoint");
	}

	@Then("Admin receives {int} Bad Request Status")
	public void admin_receives_bad_request_status(Integer int1) {
		logger.info("User gets error message  for bad request");
		programModule.validateResponseCode(400);
	}

	@Given("Admin creates GET Request for the LMS API for valid endpoint")
	public void admin_creates_get_request_for_the_lms_api_for_valid_endpoint() {
     programModule.prepareRequest("RetrieveAllProgramsValidEndpoint");
	}

	@Given("Admin creates GET Request for the LMS API for invalid method")
	public void admin_creates_get_request_for_the_lms_api_for_invalid_method() {
		programModule.prepareRequest("RetrieveAllProgramsInvalidMethod");
	}
	
	@Given("Admin creates GET Request for the LMS API for invalid endpoint")
	public void admin_creates_get_request_for_the_lms_api_for_invalid_endpoint_program() {
	    programModule.prepareRequest("RetrieveProgramvalidIDInvalidEndpoint");
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details_program(Integer int1) {
		logger.info("User gets error message for not found");
		programModule.validateResponseCode(404);
 
	}


}
