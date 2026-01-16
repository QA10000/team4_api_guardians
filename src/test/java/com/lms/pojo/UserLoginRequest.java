package com.lms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequest {

	@JsonProperty("userLoginEmail")
    private String userLoginEmail;

	@JsonProperty("loginStatus")
    private String loginStatus;

	@JsonProperty("status")
    private String status;

    public UserLoginRequest(String userLoginEmail, String loginStatus, String status) {
        this.userLoginEmail = userLoginEmail;
        this.loginStatus = loginStatus;
        this.status = status;
    }

	public String getuserLoginEmail() {
		return userLoginEmail;
	}

	public void setuserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}

	public String getloginStatus() {
		return loginStatus;
	}

	public void setloginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

}