package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.FacebookDao;
import com.jamie.rms.model.Facebook;

@Service
public class FacebookServiceImpl implements FacebookService {

	@Autowired
	private FacebookDao facebookDao;
	
	@Override
	public Facebook save(Facebook facebook) {
		// TODO Auto-generated method stub
		return facebookDao.save(facebook);
	}

	@Override
	public List<Facebook> findAll() {
		// TODO Auto-generated method stub
		return facebookDao.findAll();
	}

	@Override
	public Facebook findByFacebookId(String facebookId) {
		// TODO Auto-generated method stub
		return facebookDao.findByFacebookId(facebookId);
	}

	@Override
	public int countFacebookId(String facebookId) {
		// TODO Auto-generated method stub
		return facebookDao.countFacebookId(facebookId);
	}
	
	

}
