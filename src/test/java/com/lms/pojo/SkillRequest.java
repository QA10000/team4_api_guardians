package com.lms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Response;

public class SkillRequest {

	@JsonProperty("skillId")
	private int SkillId;

	@JsonProperty("skillName")
	private String skillName;

	@JsonProperty("lastResponse")
	private Response lastResponse;

	public SkillRequest(String skillName) {

		this.skillName = skillName;
	}

	public String getskillName() {
		return skillName;
	}

	public void setskillName(String skillName) {
		this.skillName = skillName;
	}

	public Response getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(Response lastResponse) {
		this.lastResponse = lastResponse;
	}

}
