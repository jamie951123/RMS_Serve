package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.QuantityProfile;

public interface QuantityProfileService {
	List<QuantityProfile> findAll();
	List<QuantityProfile> findByPartyId(String partyId);
}
