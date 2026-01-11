package com.lms.stepdefinitions;

import com.lms.ObjectRepo.BatchModule;
import com.lms.utils.ConfigManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchModule_Sindhuja {

    private BatchModule batchModule;

    public BatchModule_Sindhuja() {
        batchModule = new BatchModule();
    }
    @Given("Admin creates GET Request with valid Batch ID")
    public void adminCreatesGETRequestWithValidBatchID() {
        batchModule.prepareBatchRequest("Get Valid Batch ID Generic");
        
    }

    @When("Admin sends HTTPS Request with endpoint")
    public void adminSendsHTTPSRequestWithEndpoint() {
        batchModule.sendGetBatchRequest();
    }

    @Then("Admin receives {int} OK Status with response body.")
    public void adminReceivesOKStatusWithResponseBody(int statusCode) {
        batchModule.validateSuccessResponse(statusCode);
    }

    @Given("Admin creates DELETE Request with valid BatchId")
    public void adminCreatesDELETERequestWithValidBatchId() {
        batchModule.prepareBatchRequest("Delete Valid Batch ID Generic");
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
}
