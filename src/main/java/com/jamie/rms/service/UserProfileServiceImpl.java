package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.UserProfileDao;
import com.jamie.rms.modle.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	@Autowired
	private UserProfileDao userProfileDao;
	
	@Override
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		return userProfileDao.findAll();
	}

	@Override
	public List<UserProfile> findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userProfileDao.findByUsernameAndPassword(username,password);
	}

}
