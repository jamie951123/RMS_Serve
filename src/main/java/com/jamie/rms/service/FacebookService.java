package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.Facebook;

public interface FacebookService {
//	Find
	List<Facebook> findAll();
	Facebook findByFacebookId(String facebookId);
	int countFacebookId(String facebookId);
//	Save
	Facebook save(Facebook facebook);
}
