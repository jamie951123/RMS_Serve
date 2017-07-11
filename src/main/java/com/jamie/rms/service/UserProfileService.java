package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAll();
	List<UserProfile> findByUsernameAndPassword(String username, String password);
	UserProfile save (UserProfile userProfile);
	UserProfile findByFacebookId(String facebookId);
}
