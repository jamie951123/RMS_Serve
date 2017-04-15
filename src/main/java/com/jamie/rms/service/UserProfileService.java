package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.modle.UserProfile;

public interface UserProfileService {
	List<UserProfile> findAll();
	List<UserProfile> findByUsernameAndPassword(String username, String password) ;
}
