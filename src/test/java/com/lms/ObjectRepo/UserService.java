package com.lms.ObjectRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Map;
import com.lms.pojo.UserRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import com.lms.utils.RestAssuredUtil;
import com.lms.utils.TestContext;
import com.lms.utils.TokenManager;

import io.restassured.response.Response;

public class UserService {

	private final TestContext context;

	public UserService(TestContext context) {

		this.context = context;
	}

	public void loadUserData(String testCaseId) {

		String filepath = ConfigManager.get("testData");
		Map<String, String> UserData = ExcelReader.getRowByTestCaseId(filepath, "User", testCaseId);

		context.setuserFirstName(UserData.get("userFirstName"));
		context.setuserMiddleName(UserData.get("userMiddleName"));
		context.setuserLastName(UserData.get("userLastName"));
		context.setuserComments(UserData.get("userComments"));
		context.setuserEduPg(UserData.get("userEduPg"));
		context.setuserEduUg(UserData.get("userEduUg"));
		context.setuserLinkedinUrl(UserData.get("userLinkedinUrl"));
		context.setuserLocation(UserData.get("userLocation"));
		context.setuserTimeZone(UserData.get("userTimeZone"));
		context.setuserVisaStatus(UserData.get("userVisaStatus"));
		context.setPhoneNumber(UserData.get("userPhoneNumber"));

		context.setroleId(UserData.get("roleId"));
		context.setuserRoleStatus(UserData.get("userRoleStatus"));

		context.setloginStatus(UserData.get("loginStatus"));
		context.setuserLoginEmail(UserData.get("userLoginEmail"));
		context.setloginStatus(UserData.get("status"));

		context.setContentType(UserData.get("ContentType"));
		context.setExpectedStatus(UserData.get("ExpectedStatus"));
		context.setEndPoint(UserData.get("Endpoint"));

	}

	public void postUserRequest() {

		UserRequest objUserReq = new UserRequest(context.getuserComments(), context.getuserEduPg(),
				context.getuserEduUg(), context.getuserLinkedinUrl(), context.getuserMiddleName(),
				context.getuserFirstName(), context.getuserLastName(), context.getuserLocation(),
				context.getuserTimeZone(), context.getuserVisaStatus(), context.getroleID(),
				context.getuserRoleStatus(), context.getuserLoginEmail(), context.getloginStatus(), context.getstatus(),
				context.getPhoneNumber());

		Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), objUserReq,
				context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 201) {
			String userId = response.jsonPath().getString("user.userId");
			String roleId = response.jsonPath().getString("user.roleId");
			assertNotNull(userId, "User Id is missing in response");
			assertNotNull(roleId, "Role Id is missing in response");
			TokenManager.saveUserId(userId);
			TokenManager.saveRoleId(roleId);
		}
	}

	public void getAllUserRequest() {

		Response response = RestAssuredUtil.makeRequest("GET", null, null, context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");

			assertNotNull(userId, "User Id is missing in response");
		}
	}

	public void getAllStaffRequest() {

		Response response = RestAssuredUtil.makeRequest("GET", null, null, context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");

			assertNotNull(userId, "User Id is missing in response");
		}
	}

	public void getAllUser_withRole() {

		Response response = RestAssuredUtil.makeRequest("GET", null, null, context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");

			assertNotNull(userId, "User Id is missing in response");
		}
	}

	public void getUser_ByUserId() {

		UserRequest objUserReq = new UserRequest(TokenManager.getUserId());

		Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), objUserReq,
				context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");
			String userName = context.getLastResponse().jsonPath().getString("user.userName");

			assertNotNull(userId, "User Id is missing in response");
			assertNotNull(userName, "User Name is missing in response");
		}

	}

	public void getUser_ByInvalidUserId() {

		UserRequest objUserReq = new UserRequest(context.getuserId());

		Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), objUserReq,
				context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");
			String userName = context.getLastResponse().jsonPath().getString("user.userName");

			assertNotNull(userId, "User Id is missing in response");
			assertNotNull(userName, "User Name is missing in response");
		}

	}

	public void putUserRequest_ByUserId() {

		UserRequest objUserReq = new UserRequest(TokenManager.getUserId());

		Response response = RestAssuredUtil.makeRequest("PUT", context.getContentType(), objUserReq,
				context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String userId = context.getLastResponse().jsonPath().getString("user.userId");
			String userName = context.getLastResponse().jsonPath().getString("user.userName");

			assertNotNull(userId, "user Id is missing in response");
			assertNotNull(userName, "user Name is missing in response");
		}

	}

	public void putUserRequest_ByRoleId() {

		UserRequest objUserReq = new UserRequest(TokenManager.getRoleId());

		Response response = RestAssuredUtil.makeRequest("PUT", context.getContentType(), objUserReq,
				context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 200) {

			String roleId = context.getLastResponse().jsonPath().getString("user.roleId");
			String rolenameName = context.getLastResponse().jsonPath().getString("user.roleName");

			assertNotNull(roleId, "role Id is missing in response");
			assertNotNull(rolenameName, "role Name is missing in response");
		}
	}

	public void assertStatusCode(Integer expectedStatusCode) {
		assertEquals("Expected " + expectedStatusCode + " status code", expectedStatusCode.intValue(),
				context.getLastResponse().statusCode());
	}

	public void assertStatusCodeWithMessage(Integer expectedStatusCode, String expectedMessage) {
		assertEquals("Expected " + expectedMessage + " message", expectedMessage,
				context.getLastResponse().getStatusLine());
		assertEquals("Expected " + expectedStatusCode + " status code", expectedStatusCode.intValue(),
				context.getLastResponse().statusCode());
	}
}