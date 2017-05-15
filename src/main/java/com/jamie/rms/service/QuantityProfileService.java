package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.QuantityProfile;
import com.jamie.rms.model.ResponseMessage;

public interface QuantityProfileService {
	List<QuantityProfile> findAll();
	List<QuantityProfile> findByPartyId(String partyId);
	ResponseMessage delete(QuantityProfile quantityProfile);
	QuantityProfile save (QuantityProfile quantityProfile);
	int updateQtyByQuantityIdAndPartyIdAndQtyUnit(QuantityProfile quantityProfile);
}
