package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.UserProfile;

public interface UserProfileService {
	
	//Find
	List<UserProfile> findAll();
	List<UserProfile> findByUsernameAndPassword(String username, String password);
	UserProfile findByPartyId(String partyId);
	UserProfile findByFacebookId(String facebookId);
	
	
	//Save
	UserProfile save (UserProfile userProfile);

}
