package com.lms.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lms.ObjectRepo.SkillService;
import com.lms.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SkillStep {

	private final TestContext context;
	private final SkillService objSkillService;

	public SkillStep(TestContext context) {

		this.context = context;
		this.objSkillService = new SkillService(context);
	}

	@Given("Admin creates POST Request for New Skill Master for the LMS API endpoint {string}")
	public void admin_creates_post_request_for_new_skill_master_for_the_lms_api_endpoint(String testCaseId) {

		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request and request Body with mandatory fields for New Skill Master")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields_for_new_skill_master()
			throws JsonProcessingException {

		objSkillService.postSkillRequest();
	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer expectedStatusCode) {

		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Then("Admin receives {int} Bad Request Status with message {string}")
	public void admin_receives_bad_request_status_with_message(Integer expectedStatusCode, String ExpectedMessage) {
		objSkillService.assertStatusCodeWithMessage(expectedStatusCode, ExpectedMessage);
	}

	@Then("Admin receives {int} Error")
	public void admin_receives_error(Integer expectedStatusCode) {
		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Given("Admin creates GET Request for the LMS API endpoint {string}")
	public void admin_creates_get_request_for_the_lms_api_endpoint(String testCaseId) {

		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request for get all Skill Master details")
	public void admin_sends_https_request_for_get_all_skill_master_details() {

		objSkillService.getAllSkill();
	}

	@Then("Admin receives {int} Status with response body\\(showing all the list of skills)")
	public void admin_receives_status_with_response_body_showing_all_the_list_of_skills(Integer expectedStatusCode) {
		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Given("Admin creates GET Request to get Skill Master by Name for the LMS API endpoint {string}")
	public void admin_creates_get_request_to_get_skill_master_by_name_for_the_lms_api_endpoint(String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request with SkillMasterName")
	public void admin_sends_https_request_with_skill_master_name() {
		objSkillService.getSkill_ByName();
	}

	@Then("Admin receives {int} Status with response body")
	public void admin_receives_status_with_response_body(Integer expectedStatusCode) {
		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Given("Admin creates GET Request to get Skill Master Name with invalid endpoint for the LMS API {string}")
	public void admin_creates_get_request_to_get_skill_master_name_with_invalid_endpoint_for_the_lms_api(
			String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request with invalid SkillMasterName")
	public void admin_sends_https_request_with_invalid_skill_master_name() {
		objSkillService.getSkill_ByName();
	}

	@Then("Admin receives {int} Not Found Status with message {string}")
	public void admin_receives_not_found_status_with_message(Integer expectedStatusCode, String ExpectedMessage) {
		objSkillService.assertStatusCodeWithMessage(expectedStatusCode, ExpectedMessage);
	}

	@Given("Admin creates  PUT Request to update New Skill Master for the LMS API endpoint {string}")
	public void admin_creates_put_request_to_update_new_skill_master_for_the_lms_api_endpoint(String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request and request Body to update New Skill Master with mandatory fields")
	public void admin_sends_https_request_and_request_body_to_update_new_skill_master_with_mandatory_fields() {
		objSkillService.putSkill_BySkillId();
	}

	@Then("Admin receives {int} Status with updated response body")
	public void admin_receives_status_with_updated_response_body(Integer expectedStatusCode) {
		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Given("Admin creates  PUT Request to update New Skill Master with invalid endpoint for the LMS API endpoint {string}")
	public void admin_creates_put_request_to_update_new_skill_master_with_invalid_endpoint_for_the_lms_api_endpoint(
			String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request and request Body with mandatory with wrong skillID")
	public void admin_sends_https_request_and_request_body_with_mandatory_with_wrong_skill_id() {
		objSkillService.putSkill_BySkillId();
	}

	@Then("Admin receives {int} Bad Request with   {string}")
	public void admin_receives_bad_request_with(Integer expectedStatusCode, String ExpectedMessage) {
		objSkillService.assertStatusCodeWithMessage(expectedStatusCode, ExpectedMessage);
	}

	@Given("Admin creates  DELETE Request to Delete  Skill ID for the LMS API endpoint {string}")
	public void admin_creates_delete_request_to_delete_skill_id_for_the_lms_api_endpoint(String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request to Delete  Skill ID")
	public void admin_sends_https_request_to_delete_skill_id() {
		objSkillService.deleteSkill_BySkillId();
	}

	@Then("Admin receives {int} Status")
	public void admin_receives_status(Integer expectedStatusCode) {
		objSkillService.assertStatusCode(expectedStatusCode);
	}

	@Given("Admin creates  DELETE Request for the LMS API endpoint {string}")
	public void admin_creates_delete_request_for_the_lms_api_endpoint(String testCaseId) {
		objSkillService.loadSkillData(testCaseId);
	}

	@When("Admin sends HTTPS Request to Delete  Skill ID  with invalid endpoint")
	public void admin_sends_https_request_to_delete_skill_id_with_invalid_endpoint() {
		objSkillService.deleteSkill_BySkillId();
	}

	@Then("Admin receives {int} Error with response body {string}")
	public void admin_receives_error_with_response_body(Integer expectedStatusCode, String ExpectedMessage) {
		objSkillService.assertStatusCodeWithMessage(expectedStatusCode, ExpectedMessage);
	}

}
