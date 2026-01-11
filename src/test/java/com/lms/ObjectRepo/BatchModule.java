package com.lms.ObjectRepo;

import com.lms.hooks.Hooks;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BatchModule {

    private Response response;
    private static final String SHEET_NAME = "Batch";
    private final String filepath = ConfigManager.get("testData");
    private String method;
    private String endpoint;
    private Map<String, Object> pathParams = new HashMap<>();

    public void setBearerAuthorization() {

        Hooks.getRequest().header("Authorization", "Bearer " + ConfigManager.get("token"));
    }
    public void prepareBatchRequest(String testCaseId) {

        Map<String, String> batchData =
                ExcelReader.getRowByTestCaseId(filepath, SHEET_NAME, testCaseId);

        method = batchData.get("Request Type");
        endpoint = batchData.get("Endpoint");
        String pathParamType = batchData.get("Path Param");

        if (method == null || endpoint == null) {
            throw new RuntimeException(
                    "Request Type or Endpoint missing for test case: " + testCaseId
            );
        }

        // Resolve path parameter
        switch (pathParamType) {

            case "Batch ID":
                pathParams.put("batchId", batchData.get("Batch ID"));
                break;

            case "Batch Name":
                pathParams.put("batchName", batchData.get("Batch Name"));
                break;

            case "Program ID":
                pathParams.put("programId", batchData.get("Program ID"));
                break;

            default:
                // For cases where path param value is not required
                System.out.println("No path param required for: " + testCaseId);
        }
    }

    public void sendGetBatchRequest() {

        switch (method.toUpperCase()) {

            case "GET":
                response = Hooks.getRequest()
                        .pathParams(pathParams)
                        .when()
                        .get(endpoint);
                break;

            case "DELETE":
                response = Hooks.getRequest()
                        .pathParams(pathParams)
                        .when()
                        .delete(endpoint);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported HTTP Method: " + method
                );
        }
    }

    public void validateSuccessResponse(int expectedStatusCode) {

        response.then().statusCode(expectedStatusCode);
        System.out.println("Response Body:\n" + response.asPrettyString());
    }
}
