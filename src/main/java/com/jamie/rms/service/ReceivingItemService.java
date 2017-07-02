package com.jamie.rms.service;

import java.util.List;
import java.util.Set;

import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;

public interface ReceivingItemService {

	//Find
	List<ReceivingItem> findAll();

	List<ReceivingItem> findByPartyId(String partyId);
	
	List<ReceivingItem> findByProductId(Long productId);

	ReceivingItem findByReceivingID(Long receivingID);
	
	//update
	ResponseMessage updateOrderIdNullByOrderId(Long orderId);
	
	ResponseMessage updateProductIdNullByProductId(Long productId);
	//save
	List<ReceivingItem> saves(List<ReceivingItem> receivingItems);
	
	ReceivingItem save(ReceivingItem receivingItem);
	
	//delete
	ResponseMessage delete(ReceivingItem receivingItem);

	ResponseMessage deletes(List<ReceivingItem> receivingItems);
	
	ResponseMessage deleteByProductId(Long productId);
	
	ResponseMessage deleteByOrderId(Long orderId);

	
}
