package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.WeightProfileDao;
import com.jamie.rms.model.WeightProfile;

@Service
public class WeightProfileServiceImpl implements WeightProfileService{
	
	@Autowired
	private WeightProfileDao weightProfileDao;
	
	@Override
	public List<WeightProfile> findAll() {
		// TODO Auto-generated method stub
		return weightProfileDao.findAll();
	}
	
	@Override
	public List<WeightProfile> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return weightProfileDao.findByPartyId(partyId);
	}



}
