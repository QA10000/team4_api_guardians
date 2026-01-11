package com.lms.ObjectRepo;

import com.lms.hooks.Hooks;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import io.restassured.response.Response;

import java.util.Map;

public class BatchModule {

    private Response response;
    private String batchId;

    private static final String SHEET_NAME = "Batch";
    private final String filepath = ConfigManager.get("testData");

    public void createGetBatchRequest(String testCaseId) {

        Map<String, String> batchData =
                ExcelReader.getRowByTestCaseId(filepath,SHEET_NAME,testCaseId);

        batchId = batchData.get("Batch ID");
        System.out.println(batchId);

        if (batchId == null || batchId.isEmpty()) {
            throw new RuntimeException(
                    "Batch ID is missing for test case: " + testCaseId
            );
        }
    }

    public void sendGetBatchRequest() {

        response = Hooks.getRequest()
                .pathParam("batchId", batchId)
                .when()
                .get("/batches/batchId/{batchId}");
    }

    public void validateSuccessResponse(int expectedStatusCode) {

        response.then().statusCode(expectedStatusCode);
        System.out.println("Response Body:\n" + response.asPrettyString());
    }
}
