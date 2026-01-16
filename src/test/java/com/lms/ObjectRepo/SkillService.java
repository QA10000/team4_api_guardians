package com.lms.ObjectRepo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Map;
import com.lms.pojo.SkillRequest;
import com.lms.utils.ConfigManager;
import com.lms.utils.ExcelReader;
import com.lms.utils.RestAssuredUtil;
import com.lms.utils.TokenManager;
import com.lms.utils.TestContext;
import io.restassured.response.Response;

public class SkillService {

	private final TestContext context;

	public SkillService(TestContext context) {

		this.context = context;
	}

	public void loadSkillData(String testCaseId) {

		String filepath = ConfigManager.get("testData");
		Map<String, String> SkillData = ExcelReader.getRowByTestCaseId(filepath,"Skill",testCaseId);

		context.setskillName(SkillData.get("skillName"));
		context.setEndPoint(SkillData.get("Endpoint"));
		context.setContentType(SkillData.get("ContentType"));
		context.setExpectedStatus(SkillData.get("ExpectedStatus"));
	}

	public void postSkillRequest() {

		SkillRequest objSkillReq = new SkillRequest(context.getskillName());

		Response response = RestAssuredUtil.makeRequest("POST", context.getContentType(), objSkillReq,context.getEndPoint());
		context.setLastResponse(response);

		if (response.statusCode() == 201) {
			String skillId = response.jsonPath().getString("skill.skillId");
			String skillName = context.getLastResponse().jsonPath().getString("skill.skillName");
			assertNotNull(skillId, "Skill Id is missing in response");
			assertNotNull(skillName, "Skill Id is missing in response");
			TokenManager.saveSkillId(skillId);
		}
	}

	public void getAllSkill() {
		
		Response response = RestAssuredUtil.makeRequest("GET", null, null,context.getEndPoint());
		context.setLastResponse(response);
		
		if (response.statusCode() == 200) {
			
			String skillId = context.getLastResponse().jsonPath().getString("skill.skillId");
			String skillName = context.getLastResponse().jsonPath().getString("skill.skillName");
			
			assertNotNull(skillId, "Skill Id is missing in response");
			assertNotNull(skillName, "Skill Name is missing in response");
		}	
	}
	
	
	public void getSkill_ByName() {
		
		SkillRequest objSkillReq = new SkillRequest(context.getskillName());
		
		Response response = RestAssuredUtil.makeRequest("GET", context.getContentType(), objSkillReq,context.getEndPoint());
		context.setLastResponse(response);
		
		if (response.statusCode() == 200) {
			
			String skillId = context.getLastResponse().jsonPath().getString("skill.skillId");
			String skillName = context.getLastResponse().jsonPath().getString("skill.skillName");
			
			assertNotNull(skillId, "Skill Id is missing in response");
			assertNotNull(skillName, "Skill Name is missing in response");
		}	
		
	}
	public void putSkill_BySkillId() {
		
		SkillRequest objSkillReq = new SkillRequest(TokenManager.getSkillId());
		
		Response response = RestAssuredUtil.makeRequest("PUT", context.getContentType(), objSkillReq,context.getEndPoint());
		context.setLastResponse(response);
		
		if (response.statusCode() == 200) {
			
			String skillId = context.getLastResponse().jsonPath().getString("skill.skillId");
			String skillName = context.getLastResponse().jsonPath().getString("skill.skillName");
			
			assertNotNull(skillId, "Skill Id is missing in response");
			assertNotNull(skillName, "Skill Name is missing in response");
		}	
		
	}
	public void deleteSkill_BySkillId() {
		
		SkillRequest objSkillReq = new SkillRequest(TokenManager.getSkillId());
		
		Response response = RestAssuredUtil.makeRequest("DELETE", context.getContentType(), objSkillReq,context.getEndPoint());
		context.setLastResponse(response);
		
		if (response.statusCode() == 200) {
			
			String skillId = context.getLastResponse().jsonPath().getString("skill.skillId");
			String skillName = context.getLastResponse().jsonPath().getString("skill.skillName");
			
			assertNotNull(skillId, "Skill Id is missing in response");
			assertNotNull(skillName, "Skill Name is missing in response");
		}
	}
	

	public void assertStatusCode(Integer expectedStatusCode) {
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }
	
	public void assertStatusCodeWithMessage(Integer expectedStatusCode, String expectedMessage) {
        assertEquals("Expected " + expectedMessage + " message",
                expectedMessage, context.getLastResponse().getStatusLine());
        assertEquals("Expected " + expectedStatusCode + " status code",
                expectedStatusCode.intValue(), context.getLastResponse().statusCode());
    }
}


