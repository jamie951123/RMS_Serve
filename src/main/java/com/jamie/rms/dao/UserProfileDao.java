package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile,Long>{

	//Find
	
	List<UserProfile> findAll();
	
	List<UserProfile> findByUsernameAndPassword(String username, String password);
	
	UserProfile findByFacebookId(String facebookId);
	
	UserProfile findByPartyId(String partyId);
}
