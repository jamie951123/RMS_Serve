package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.ResponseMessage;




public interface DeliveryItemService {
	//Find 
	List<DeliveryItem> findAll();
	
	//Save 
	List<DeliveryItem> saves(List<DeliveryItem> deliveryItem);
	
//	Delete
	ResponseMessage delete(DeliveryItem deliveryItem);
	
	ResponseMessage deletes(List<DeliveryItem> deliveryItems);
	
	ResponseMessage deleteByOrderId(Long deliveryOrderId);
}
