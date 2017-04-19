package com.jamie.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jamie.rms.model.UserProfile;
import com.jamie.rms.service.UserProfileService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

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
	
	
	@RequestMapping(value="/findAll")
	public @ResponseBody List<UserProfile> findAll(){
		List<UserProfile> UserProfile = userProfileService.findAll();
		log.info("User Response(findAll) : "+ UserProfile);
		return UserProfile;
	}
	@RequestMapping(value="/checklogin",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody LoginResponse checklogin (@RequestBody String json) {	
		log.info("[login]-[checklogin]-User Request(JSON) : "+ json);
		List<UserProfile> checklogin = new ArrayList<>();
		try{
			LoginRequeset loginRequest = new LoginRequeset();
			Gson gson = GsonUtil.getGson();
			loginRequest = gson.fromJson(json, LoginRequeset.class);
			String username = loginRequest.getUsername();
			String password = loginRequest.getPassword();
			log.info("User Request : "+ "--Username :"+username+"--Password :"+password);
			
			if(ObjectUtil.isNotNullEmpty(username) && ObjectUtil.isNotNullEmpty(password)){
				 checklogin = userProfileService.findByUsernameAndPassword(username,password);
			}
		
		}catch (Exception e){
			log.error("[login]-[checklogin]-User Request(JSON-Format) :"+ "Wrong Format");
		}
		log.info("[login]-[checklogin]-User Response(checklogin) : "+ checklogin);
		LoginResponse loginResponse = new LoginResponse();
		
		if(checklogin.size() == 0){
			loginResponse.setLoginStatus(loginFail);
			loginResponse.setLoginMessage(worngAccount);
		}else if(checklogin.size() == 1){
			loginResponse.setUserProfile(checklogin.get(0));
			loginResponse.setLoginStatus(successful);
			loginResponse.setLoginMessage(successfulAccount);

		}else if (checklogin.size() >1){
			loginResponse.setLoginStatus(loginFail);
			loginResponse.setLoginMessage(duplicateAccount);
		}
		log.info("[login]-[checklogin]-User Response(LoginResponse) : "+ loginResponse);
		return loginResponse;
	}
}

class LoginRequeset{
	private String username;
	private String password;
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
	@Override
	public String toString() {
		return "LoginRequeset [username=" + username + ", password=" + password + "]";
	}
	
	
}
class LoginResponse{
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

