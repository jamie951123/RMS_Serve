package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.QuantityProfileDao;
import com.jamie.rms.model.QuantityProfile;

@Service
public class QuantityProfileServiceImpl implements QuantityProfileService {

	@Autowired
	private QuantityProfileDao quantityProfileDao;
	
	@Override
	public List<QuantityProfile> findAll() {
		// TODO Auto-generated method stub
		return quantityProfileDao.findAll();
	}

	@Override
	public List<QuantityProfile> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return quantityProfileDao.findByPartyId(partyId);
	}

}
