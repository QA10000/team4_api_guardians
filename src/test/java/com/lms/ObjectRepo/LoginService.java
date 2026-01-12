package com.lms.ObjectRepo;

import java.util.Map;

import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import com.lms.utils.TestContext;

public class LoginService {

    private final TestContext context;

    public LoginService(TestContext context) {
        this.context = context;
    }

    public void loadLoginData(String testCaseId) {

        String filepath = ConfigManager.get("testData");
        Map<String, String> loginData =
                ExcelReader.getRowByTestCaseId(filepath, "UserLogin", testCaseId);

        context.setEmail(loginData.get("Email"));
        context.setPassword(loginData.get("Password"));
        context.setEndPoint(loginData.get("Endpoint"));
        context.setContentType(loginData.get("ContentType"));
        context.setExpectedStatus(loginData.get("ExpectedStatus"));
    }
}
