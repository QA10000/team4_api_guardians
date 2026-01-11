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
        batchModule.createGetBatchRequest("Valid Batch ID Generic");
        
    }

    @When("Admin sends HTTPS Request with endpoint")
    public void adminSendsHTTPSRequestWithEndpoint() {
        batchModule.sendGetBatchRequest();
    }

    @Then("Admin receives {int} OK Status with response body.")
    public void adminReceivesOKStatusWithResponseBody(int arg0) {
        batchModule.validateSuccessResponse(200);
    }
}
