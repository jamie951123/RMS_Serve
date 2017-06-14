package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.ResponseMessage;

public interface ReceivingOrderService {
	//Find
	List<ReceivingOrder> findAll();
	List<ReceivingOrder> findByPartyId(String partyId);
	ReceivingOrder findByOrderId(Long orderId);
	//Updata
	
	
	//Save
	ReceivingOrder save(ReceivingOrder receivingOrder);
	
	//Delete
	ResponseMessage deleteByOrderId(Long orderId);
}
