package com.lms.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest {

    @JsonProperty("userLoginEmailId")
    private String userLoginEmailId;

    @JsonProperty("password")
    private String password;

    public LoginRequest() {}

    public LoginRequest(String userLoginEmailId, String password) {
        this.userLoginEmailId = userLoginEmailId;
        this.password = password;
    }

    public String getUserLoginEmailId() {
        return userLoginEmailId;
    }

    public void setUserLoginEmailId(String userLoginEmailId) {
        this.userLoginEmailId = userLoginEmailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

