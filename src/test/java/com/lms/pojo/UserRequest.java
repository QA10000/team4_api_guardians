
package com.lms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty("userID")
    private int userID;
    
    @JsonProperty("userComments")
    private String userComments;

    @JsonProperty("userEduPg")
    private String userEduPg;

    @JsonProperty("userEduUg")
    private String userEduUg;

    @JsonProperty("userLinkedinUrl")
    private String userLinkedinUrl;

    @JsonProperty("userMiddleName")
    private String userMiddleName;

    @JsonProperty("userFirstName")
    private String userFirstName;

    @JsonProperty("userLastName")
    private String userLastName;

    @JsonProperty("userLocation")
    private String userLocation;

    @JsonProperty("userTimeZone")
    private String userTimeZone;

    @JsonProperty("userVisaStatus")
    private String userVisaStatus;
    
    @JsonProperty("userPhoneNumber")
    private String userPhoneNumber;

    @JsonProperty("userRoleMaps")
    public UserRoleMapRequest userRoleMaps;

    @JsonProperty("userLogin")
    public UserLoginRequest userLogin;
    
    String name;
    
    public UserRequest(String UserName) {

		this.name = UserName;
	}

    public UserRequest(
    		String userComments,
            String userEduPg,
            String userEduUg,
            String userLinkedinUrl,
            String userMiddleName,
            String userFirstName,
            String userLastName,
            String userLocation,
            String userTimeZone,
            String userVisaStatus,
            String userPhoneNumber,
            String roleId,
            String roleStatus,
            String userLoginEmail,
            String loginStatus,
            String status) {
    	
    	 this.userComments = userComments;
         this.userEduPg = userEduPg;
         this.userEduUg = userEduUg;
         this.userLinkedinUrl = userLinkedinUrl;
         this.userMiddleName = userMiddleName;	
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLocation = userLocation;
        this.userTimeZone = userTimeZone;
        this.userVisaStatus = userVisaStatus;
        this.userPhoneNumber = userPhoneNumber;

        
        this.userRoleMaps = new UserRoleMapRequest(roleId, roleStatus);
        this.userLogin = new UserLoginRequest(userLoginEmail, loginStatus, status);
    }

    public String getuserFirstName() {
        return userFirstName;
    }

    public void setuserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getuserLastName() {
        return userLastName;
    }

    public void setuserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getuserLocation() {
        return userLocation;
    }

    public void setuserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getuserTimeZone() {
        return userTimeZone;
    }

    public void setuserTimeZone(String userTimeZone) {
        this.userTimeZone = userTimeZone;
    }

    public String getuserVisaStatus() {
        return userVisaStatus;
    }

    public void setuserVisaStatus(String userVisaStatus) {
        this.userVisaStatus = userVisaStatus;
    }
    
    public String getPhoneNumber() {
        return userPhoneNumber;
    }

    public void setPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getuserComments() {
        return userComments;
    }

    public void setuserComments(String userComments) {
        this.userComments = userComments;
    }
    public String getuserEduPg() {
        return userEduPg;
    }

    public void setuserEduPg(String userEduPg) {
        this.userEduPg = userEduPg;
    }
    public String getuserEduUg() {
        return userEduUg;
    }

    public void setuserEduUg(String userEduUg) {
        this.userEduUg = userEduUg;
    }
    public String getuserLinkedinUrl() {
        return userLinkedinUrl;
    }

    public void setuserLinkedinUrl(String userLinkedinUrl) {
        this.userLinkedinUrl = userLinkedinUrl;
    }
    public String getuserMiddleName() {
        return userMiddleName;
    }

    public void setuserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }
    
}