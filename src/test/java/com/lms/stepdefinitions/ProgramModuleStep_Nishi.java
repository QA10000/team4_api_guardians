package com.lms.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.ObjectRepo.ProgramModule;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProgramModuleStep_Nishi {
	private ProgramModule programModule;
	private static final Logger logger = LogManager.getLogger(ProgramModuleStep_Nishi.class);


public ProgramModuleStep_Nishi(){
	programModule = new ProgramModule();
}
	
	@Given("Admin creates POST Request for the LMS with request body for program module")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_program_module() {
	   programModule.prepareRequest("CreateProgram");

	}

	@When("Admin sends HTTPS Request and request Body with endpoint for program module")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module() {
		programModule.setBearerAuthorization();
	    programModule.sendGetProgramRequest();
	 	}

	@Then("Admin receives {int} Created Status with response body for program module")
	public void admin_receives_created_status_with_response_body_for_program_module(Integer int1) {
	    programModule.validateResponseWithUpdatedValues(201, null);
		logger.info("user gets 201 status");

	}
//1st scenaro
	
	@Given("Admin creates POST Request for the LMS with request body for program module without authorization")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_program_module_without_authorization() {
		   programModule.prepareRequest("CreateProgramWitoutAuthoriztion");

	}
	
	@When("Admin sends HTTPS Request and  request Body with endpoint for program module")// it is a duplicated method
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module_prog() {
	    programModule.sendGetProgramRequest();
	}

	@Then("Admin receives {int} Unauthorized for program module for program module")
	public void admin_receives_unauthorized_for_program_module_for_program_module(Integer int1) {
	    programModule.validateResponseWithUpdatedValues(401, null);
		logger.info("user gets 401 status");


	}
	// second scenario 
	
	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() {
		   programModule.prepareRequest("CreateProgramWithValidLengthProgramDescription");

	}
	@When("Admin sends HTTPS Request and  request Body with endpoint for program module with valid description")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_program_module_with_valid_description() {
		   programModule.setBearerAuthorization();
		   programModule.sendGetProgramRequest();

	}

	@Then("Admin receives {int} Created Status with response body for program module for valid description")
	public void admin_receives_created_status_with_response_body_for_program_module_for_valid_description(Integer int1) {
	    programModule.validateResponseWithUpdatedValues(201, null);
   
	}



	
// third scenario



}
