package com.jamie.rms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.QuantityProfileDao;
import com.jamie.rms.model.QuantityProfile;
import com.jamie.rms.model.ResponseMessage;

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

	@Override
	public ResponseMessage delete(QuantityProfile quantityProfile) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		r.setMessage_request(quantityProfile.toString());
		// TODO Auto-generated method stub
		try{
			quantityProfileDao.delete(quantityProfile);
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
	public QuantityProfile save(QuantityProfile quantityProfile) {
		// TODO Auto-generated method stub
		return quantityProfileDao.save(quantityProfile);
	}

	@Override
	public int updateQtyByQuantityIdAndPartyIdAndQtyUnit(QuantityProfile quantityProfile) {
		// TODO Auto-generated method stub
		Long qtyId = quantityProfile.getQuantityId();
		String qtyPartyId = quantityProfile.getPartyId();
		String qtyUnit = quantityProfile.getQuantityUnit();
		Date modifyTime = quantityProfile.getLastModifiedDate();
		String modifyBy = quantityProfile.getLastModifiedBy();
		

		return quantityProfileDao.updateQtyByQuantityIdAndPartyIdAndQtyUnit(qtyId, qtyPartyId, qtyUnit);
	}

}
