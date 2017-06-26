package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.DeliveryItem;




public interface DeliveryItemService {
	//Find 
	List<DeliveryItem> findAll();
	
	//Save 
	List<DeliveryItem> saves(List<DeliveryItem> deliveryItem);
}
