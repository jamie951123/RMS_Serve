package com.jamie.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.modle.UserProfile;
import com.jamie.rms.service.UserProfileService;

@RequestMapping(value="/rms/login")
@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserProfileService userProfileService;
	
	final static String loginFail 			= "LoginFail";
	final static String worngAccount 		= "Worng Account";
	final static String successful 			= "LoginSuccessful";
	final static String successfulAccount 	= "Successful Account";
	final static String duplicateAccount 	= "Duplicate Account";
	
	@RequestMapping(value="/checklogin") 
	public @ResponseBody LoginResponse addNewUser () {		
		List<UserProfile> checklogin = userProfileService.findByUsernameAndPassword("11","11");
		log.info("checklogin : "+ checklogin);
		LoginResponse loginResponse = new LoginResponse();

		if(checklogin.size() == 0){
			loginResponse.setLoginStatus(loginFail);
			loginResponse.setLoginMessage(worngAccount);
		}else if(checklogin.size() == 1){
			loginResponse.setLoginStatus(successful);
			loginResponse.setLoginMessage(successfulAccount);
			loginResponse.setPartyId(checklogin.get(0).getPartyId());
			loginResponse.setUsername(checklogin.get(0).getUsername());
			loginResponse.setPassword(checklogin.get(0).getPassword());
		}else if (checklogin.size() >1){
			loginResponse.setLoginStatus(loginFail);
			loginResponse.setLoginMessage(duplicateAccount);
		}
		
		return loginResponse;
	}
}

class LoginResponse{
	String username;
	String password;
	String partyId;
	String loginStatus;
	String loginMessage;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
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
	
	
}

