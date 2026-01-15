package com.lms.ObjectRepo;

import com.lms.hooks.Hooks;
import com.lms.pojo.BatchRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BatchModule {

    private Response response;
    private static final String SHEET_NAME = "Batch";
    private final String filepath = ConfigManager.get("testData");
    private String method;
    private String endpoint;
    private Map<String, Object> pathParams = new HashMap<>();
    private BatchRequest requestBody;

    private Map<String, String> batchData;

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
                response = given()
                        .spec(Hooks.getRequest())
                        .pathParams(pathParams)
                        .when()
                        .get(endpoint);
                break;

            case "DELETE":
                response = given()
                        .spec(Hooks.getRequest())
                        .pathParams(pathParams)
                        .when()
                        .delete(endpoint);
                break;

            case "PUT":
                response = given()
                        .spec(Hooks.getRequest())
                        .pathParams(pathParams)
                        .body(requestBody)
                        .when()
                        .put(endpoint);
                break;

            default:
                throw new IllegalArgumentException("Unsupported HTTP Method: " + method);
        }
    }


    public void validateResponseCode(int expectedStatusCode) {

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

    public void validateResponseField(int expectedStatus, String fieldName, String expectedValue)
    {
        response.then().statusCode(expectedStatus);
        Object responseBody = response.as(Object.class);

        if (responseBody instanceof List) {
            // Array response
            response.then().body(fieldName, hasItem(expectedValue));
        } else {
            // Object response
            response.then().body(fieldName, equalTo(expectedValue));
        }

        System.out.println("Response Body:\n" + response.asPrettyString());
    }

    public void validateNegativeResponse(int expStatusCode, String expStatusText, String testCaseId)
    {
        batchData = ExcelReader.getRowByTestCaseId(filepath, SHEET_NAME, testCaseId);
        String errorValue = batchData.get("Error Value");
        response.then()
                .statusCode(expStatusCode)
                .statusLine(containsString(expStatusText))
                .body("message", containsString(errorValue))
                .body("success", equalTo(false));

        System.out.println("Response Body:\n" + response.asPrettyString());

    }
}
