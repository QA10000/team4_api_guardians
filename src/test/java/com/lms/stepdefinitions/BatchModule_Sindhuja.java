package com.lms.stepdefinitions;

import com.lms.ObjectRepo.BatchModule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchModule_Sindhuja {

    private BatchModule batchModule;

    public BatchModule_Sindhuja() {
        batchModule = new BatchModule();
    }

    @When("Admin sends HTTPS Request with endpoint")
    public void adminSendsHTTPSRequestWithEndpoint() {
        batchModule.sendGetBatchRequest();
    }

    @Then("Admin receives {int} OK Status with response body.")
    public void adminReceivesOKStatusWithResponseBody(int statusCode) {
        batchModule.validateResponseCode(statusCode);
    }

    @Given("Admin creates GET Request with valid Batch Name")
    public void adminCreatesGETRequestWithValidBatchName() {
        batchModule.prepareBatchRequest("Get Valid Batch Name Generic");
    }

    @Given("Admin creates GET Request with valid Program Id")
    public void adminCreatesGETRequestWithValidProgramId() {
        batchModule.prepareBatchRequest("Get Valid Program ID Generic");
    }

    @Then("Admin receives {int} OK Status with  {string} field {string} in the response body.")
    public void adminReceivesOKStatusWithFieldInTheResponseBody(int statusCode, String field, String value) {
        batchModule.validateResponseField(statusCode,field,value);
    }

    @Then("Admin receives {int} not found  Status")
    public void adminReceivesNotFoundStatus(int statusCode) {
        batchModule.validateResponseCode(statusCode);
    }

     @Given("Admin creates GET Request with {string}")
    public void adminCreatesGETRequestWith(String tcID) {
        batchModule.prepareBatchRequest(tcID);
    }

    @Given("Admin creates DELETE Request with {string}")
    public void adminCreatesDELETERequestWith(String tcID) {
        batchModule.prepareBatchRequest(tcID);
    }

    @Given("Admin creates PUT Request with {string}")
    public void adminCreatesPUTRequestWith(String tcID) {
        batchModule.prepareBatchRequest(tcID);
    }

    @Then("Admin receives {int} OK Status with updated value in response body for {string}")
    public void adminReceivesOKStatusWithUpdatedValueInResponseBodyFor(int statusCode, String tcID) {
        batchModule.validateResponseWithUpdatedValues(statusCode,tcID);
    }

    @Then("Admin receives {int} {string} Status with message and boolean success details for {string}")
    public void adminReceivesStatusWithMessageAndBooleanSuccessDetailsFor(int statusCode, String statusText, String tcID) {
        batchModule.validateNegativeResponse(statusCode,statusText,tcID);
    }

    @Then("Admin receives {int} Status with error message unauthorized.")
    public void adminReceivesStatusWithErrorMessageUnauthorized(int statusCode) {
        batchModule.validateResponseCode(statusCode);
    }

    @Given("Admin creates GET Request for {string}with search string {string} and {string}")
    public void adminCreatesGETRequestForWithSearchStringAnd(String tcID, String key, String value) {
        batchModule.prepareBatchRequestWithQryParam(tcID, key, value);
    }

    @Given("Admin creates POST Request with {string}")
    public void adminCreatesPOSTRequestWith(String tcID) {
        batchModule.prepareBatchRequest(tcID);
    }

    @Then("Admin receives {int} Created Status with response body.")
    public void adminReceivesCreatedStatusWithResponseBody(int statusCode) {
        batchModule.validatePostBatchResponse(statusCode);
    }
}
