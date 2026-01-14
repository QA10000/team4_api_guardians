package com.lms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRoleMaps {
	
	@JsonProperty("roleId")
	private String roleId;

	@JsonProperty("userRoleStatus")
    private String userRoleStatus;
	
    public UserRoleMaps(String roleId, String userRoleStatus) {
        this.roleId = roleId;
        this.userRoleStatus = userRoleStatus;
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

}