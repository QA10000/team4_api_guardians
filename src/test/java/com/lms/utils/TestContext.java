package com.lms.utils;

import io.restassured.response.Response;

public class TestContext {
    //These variables related to Login Module
    private Response lastResponse;
    private String email;
    private String password;
    private String endPoint;
    private String contentType;
    private String expectedStatus;

    //These variable related to User Module
    private String userComments;
    private String userEduPg;   
    private String userEduUg;
    private String userLinkedinUrl;
    private String userMiddleName;
    private String userFirstName;
    private String userLastName;
    private String userLocation;
    private String userTimeZone;
    private String userVisaStatus;
    private String phoneNumber;
    private String userLoginEmail;
    private String roleId;
    private String userRoleStatus;
    private String loginStatus;
    private String status;
    
    //This variable related to Skill Module
    private String skillName;

     public Response getLastResponse() {
        return lastResponse;
    }

    public void setLastResponse(Response lastResponse) {
        this.lastResponse = lastResponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExpectedStatus() {
        return expectedStatus;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = expectedStatus;
    }
/* Finished one set */
    
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

    public String getroleID() {
        return roleId;
    }

    public void setroleId(String roleId) {
        this.roleId = roleId;
    }

    public String getuserRoleStatus() {
        return userRoleStatus;
    }

    public void setuserRoleStatus(String userRoleStatus) {
        this.userRoleStatus = userRoleStatus;
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

    public String getPhoneNumber() {
         return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber;
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
    
    public String getskillName() {
        return skillName;
    }

    public void setskillName(String skillName) {
        this.skillName = skillName;
    }
    
 /*   finished 2 set */   
}