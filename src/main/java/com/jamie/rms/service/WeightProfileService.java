package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.WeightProfile;

public interface WeightProfileService {
	List<WeightProfile> findAll ();
	List<WeightProfile> findByPartyId (String partyId);
	ResponseMessage delete(WeightProfile weightProfile);
	WeightProfile save (WeightProfile weightProfile);
}
