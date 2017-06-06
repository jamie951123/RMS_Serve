package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;

public interface ReceivingItemService {

	List<ReceivingItem> findAll();
	
	List<ReceivingItem> save(List<ReceivingItem> receivingItems);
	
	List<ReceivingItem> findByPartyId(String partyId);
	
	ReceivingItem findByReceivingID(Long receivingID);
	
	ResponseMessage deleteByProductId(Long productId);
	
}
