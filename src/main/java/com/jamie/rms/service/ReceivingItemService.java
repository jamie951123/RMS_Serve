package com.jamie.rms.service;

import java.util.List;
import java.util.Set;

import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;

public interface ReceivingItemService {

	List<ReceivingItem> findAll();
	
	List<ReceivingItem> saves(List<ReceivingItem> receivingItems);
	
	ReceivingItem save(ReceivingItem receivingItem);

	List<ReceivingItem> findByPartyId(String partyId);
	
	ReceivingItem findByReceivingID(Long receivingID);
	
	ResponseMessage deleteByProductId(Long productId);
	
	ResponseMessage deleteByOrderId(Long orderId);
	
	ResponseMessage updateOrderIdNullByOrderId(Long orderId);
	
}
