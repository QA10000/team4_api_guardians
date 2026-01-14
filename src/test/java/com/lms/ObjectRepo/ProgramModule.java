package com.lms.ObjectRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;

import com.lms.hooks.Hooks;
import com.lms.pojo.ProgramRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ProgramModule {
private Response response;
private static final String SHEET_NAME = "Program";
private final String filepath = ConfigManager.get("testData");
private String method;
private String endpoint;
private Map<String, Object> pathParams = new HashMap<>();
private ProgramRequest requestBody;


private Map<String, String> batchData;


public void setBearerAuthorization() {

    Hooks.getRequest().header("Authorization", "Bearer " + ConfigManager.get("token"));
}

public void prepareRequest(String testCaseId) {

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

        case "Progam Status":
            pathParams.put("batchId", batchData.get("Program Descriiption"));
            break;

        case "Progam Name":
            pathParams.put("batchName", batchData.get("Progam Name"));
            break;

        case "Program Status":
            pathParams.put("programId", batchData.get("Program Status"));
            break;

        default:
            // For cases where path param value is not required
            System.out.println("No path param required for: " + testCaseId);
    }

    if ("POST".equalsIgnoreCase(method)) {

        requestBody = new ProgramRequest();
        requestBody.setProgramDescription(batchData.get("Program Description"));
        requestBody.setProgramName(batchData.get("Program Name"));
        requestBody.setProgramStatus(batchData.get("Program Status"));
        
    }

}

public void sendGetProgramRequest() {

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
            
        case "POST":
        	System.out.println("════════════════════════════════════════");
            System.out.println("SENDING POST REQUEST");
            System.out.println("Endpoint: " + endpoint);
            System.out.println("Request Body: " + requestBody);
            System.out.println("════════════════════════════════════════");
            
            response = Hooks.getRequest()
            		
                    .pathParams(pathParams)
                    .body(requestBody)
                    .when()
                    .post(endpoint);
            System.out.println("════════════════════════════════════════");
            System.out.println("RESPONSE RECEIVED");
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body:");
            System.out.println(response.asPrettyString());
            System.out.println("════════════════════════════════════════");
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
    response.then().statusCode(expectedStatusCode);
    Object responseBody = response.as(Object.class);
    if (responseBody instanceof List) {
        // Array response
    	response.then().body("programDescription", hasItem(batchData.get("Program Description")))
        .body("programName", hasItem(batchData.get("Program Name")))
        .body("programStatus", hasItem(batchData.get("Program Status")));

    } else {
        // Object response
    	response.then().body("programDescription", equalTo(batchData.get("Program Description")))
        .body("programName", equalTo(batchData.get("Program Name")))
        .body("programStatus", equalTo(batchData.get("Program Status")));

    }
    
            
    System.out.println("Response Body:\n" + response.asPrettyString());
}

}