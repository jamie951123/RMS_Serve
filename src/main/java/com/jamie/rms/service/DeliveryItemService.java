package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;
import com.jamie.rms.searchcriteria.object.DeliveryItemSearchObject;




public interface DeliveryItemService {
	//Find 
	List<DeliveryItem> findAll();
	
	List<DeliveryItem> findByPartyIdAndStatus(String partyId,Status status);
	
	//Save 
	List<DeliveryItem> saves(List<DeliveryItem> deliveryItem);
	
//	Delete
	ResponseMessage delete(DeliveryItem deliveryItem);
	
	ResponseMessage deletes(List<DeliveryItem> deliveryItems);
	
	ResponseMessage deleteByOrderId(Long deliveryOrderId);
	
	ResponseMessage deleteByReceivingId(Long receivingId);
	
	ResponseMessage deleteByReceivingIds (List<Long> receivingIds);
}
