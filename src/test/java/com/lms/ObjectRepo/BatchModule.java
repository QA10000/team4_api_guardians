package com.lms.ObjectRepo;

import com.lms.hooks.Hooks;
import com.lms.pojo.BatchRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class BatchModule {

    private Response response;
    private static final String SHEET_NAME = "Batch";
    private final String filepath = ConfigManager.get("testData");
    private String method;
    private String endpoint;
    private Map<String, Object> pathParams = new HashMap<>();
    private BatchRequest requestBody;

    private Map<String, String> batchData;

    public void setBearerAuthorization() {

        Hooks.getRequest().header("Authorization", "Bearer " + ConfigManager.get("token"));
    }
    public void prepareBatchRequest(String testCaseId) {

        batchData = ExcelReader.getRowByTestCaseId(filepath, SHEET_NAME, testCaseId);

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

        if ("PUT".equalsIgnoreCase(method)) {

            requestBody = new BatchRequest();
            requestBody.setBatchName(batchData.get("Batch Name"));
            requestBody.setBatchStatus(batchData.get("Batch Status"));
            requestBody.setProgramId(batchData.get("Program ID"));
            requestBody.setProgramName(batchData.get("Program Name"));
            requestBody.setBatchNoOfClasses(batchData.get("Batch No of Classes"));
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

            case "PUT":
                response = Hooks.getRequest()
                        .pathParams(pathParams)
                        .body(requestBody)
                        .when()
                        .put(endpoint);
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

    public void validateResponseWithUpdatedValues(int expectedStatusCode,String testCaseId)
    {
        batchData = ExcelReader.getRowByTestCaseId(filepath, SHEET_NAME, testCaseId);
        response.then().statusCode(expectedStatusCode)
                .body("batchName", equalTo(batchData.get("Batch Name")))
                .body("batchStatus", equalTo(batchData.get("Batch Status")))
                .body("programId", equalTo(Integer.parseInt(batchData.get("Program ID"))))
                .body("programName", equalTo(batchData.get("Program Name")))
                .body("batchNoOfClasses", equalTo(Integer.parseInt(batchData.get("Batch No of Classes"))));
        System.out.println("Response Body:\n" + response.asPrettyString());
    }
}
