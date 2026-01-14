
package com.lms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty("userID")
    private int userID;

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

    @JsonProperty("userRoleMaps")
    public UserRoleMaps userRoleMaps;

    @JsonProperty("userLogin")
    public UserLogin userLogin;

    public UserRequest(
            String userFirstName,
            String userLastName,
            String userLocation,
            String userTimeZone,
            String userVisaStatus,
            String roleId,
            String roleStatus,
            String userLoginEmail,
            String loginStatus,
            String status) {
    	
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLocation = userLocation;
        this.userTimeZone = userTimeZone;
        this.userVisaStatus = userVisaStatus;

        
        this.userRoleMaps = new UserRoleMaps(roleId, roleStatus);
        this.userLogin = new UserLogin(userLoginEmail, loginStatus, status);
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

}