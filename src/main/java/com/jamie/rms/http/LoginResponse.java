package com.jamie.rms.http;

import com.jamie.rms.model.UserProfile;

public class LoginResponse {
	private UserProfile userProfile;
	private String loginStatus;
	private String loginMessage;
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getLoginMessage() {
		return loginMessage;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	@Override
	public String toString() {
		return "LoginResponse [userProfile=" + userProfile + ", loginStatus=" + loginStatus + ", loginMessage="
				+ loginMessage + "]";
	}
	
}
