package com.jamie.rms.service;

import java.util.List;
import java.util.Set;

import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;

public interface ReceivingItemService {

	//Find
	List<ReceivingItem> findAll();

	List<ReceivingItem> findByPartyId(String partyId);
	
	ReceivingItem findByReceivingID(Long receivingID);
	
	//update
	ResponseMessage updateOrderIdNullByOrderId(Long orderId);
		
	//save
	List<ReceivingItem> saves(List<ReceivingItem> receivingItems);
	
	ReceivingItem save(ReceivingItem receivingItem);
	
	//delete
	ResponseMessage delete(ReceivingItem receivingItem);

	ResponseMessage deleteByProductId(Long productId);
	
	ResponseMessage deleteByOrderId(Long orderId);
	

	
}
