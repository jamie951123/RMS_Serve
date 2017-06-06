package com.jamie.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.controller.WeightController;
import com.jamie.rms.dao.WeightProfileDao;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.WeightProfile;

@Service
public class WeightProfileServiceImpl implements WeightProfileService{
	Logger log = LoggerFactory.getLogger(WeightController.class);

	
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

	@Override
	public ResponseMessage delete(WeightProfile weightProfile) {
		ResponseMessage r = new ResponseMessage();
		r.setMessage_request(weightProfile.toString());
		// TODO Auto-generated method stub
		try{
			weightProfileDao.delete(weightProfile);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table");
			r.setMessage_count(0);
		}
		return r;
	}

	@Override
	public WeightProfile save(WeightProfile weightProfile) {
		// TODO Auto-generated method stub
		return weightProfileDao.save(weightProfile);
	}



}
