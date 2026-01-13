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

    @Given("Admin sets Authorization to Bearer Token.")
    public void adminSetsAuthorizationToBearerToken() {
        batchModule.setBearerAuthorization();
    }

    @Given("Admin creates PUT Request with valid BatchId and Data")
    public void adminCreatesPUTRequestWithValidBatchIdAndData() {
        batchModule.prepareBatchRequest("Put Valid Batch ID Generic");
    }

    @Then("Admin receives {int} OK Status with updated value in response body.")
    public void adminReceivesOKStatusWithUpdatedValueInResponseBody(int statusCode) {
        batchModule.validateResponseWithUpdatedValues(statusCode,"Put Valid Batch ID Generic");
    }

    @Then("Admin receives {int} OK Status with  {string} field {string} in the response body.")
    public void adminReceivesOKStatusWithFieldInTheResponseBody(int statusCode, String field, String value) {
        batchModule.validateResponseField(statusCode,field,value);
    }

    @Then("Admin receives {int} Not Found Status with message and boolean success details")
    public void adminReceivesNotFoundStatusWithMessageAndBooleanSuccessDetails(int statusCode) {
        batchModule.validateNegativeResponse(statusCode,"Get Invalid Batch ID");
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

    @Then("Admin receives {int} Not Found Status with message and boolean success details for {string}")
    public void adminReceivesNotFoundStatusWithMessageAndBooleanSuccessDetailsFor(int statusCode, String tcID) {
        batchModule.validateNegativeResponse(statusCode, tcID);
    }
}
