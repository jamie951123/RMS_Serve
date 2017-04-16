package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.ReceivingItem;

public interface ReceivingItemService {

	List<ReceivingItem> findAll();
	
	List<ReceivingItem> save(List<ReceivingItem> receivingItems);
	
	List<ReceivingItem> findByPartyId(String partyId);
}
