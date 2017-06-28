package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;

public interface ReceivingOrderService {
	//Find
	List<ReceivingOrder> findAll();
	List<ReceivingOrder> findByPartyId(String partyId);
	List<ReceivingOrder> findByPartyIdAndStatus(String partyId,Status status);

	ReceivingOrder findByOrderId(Long orderId);
	//Updata
	
	
	//Save
	ReceivingOrder save(ReceivingOrder receivingOrder);
	
	//Delete
	ResponseMessage delete(ReceivingOrder receivingOrder);
	
	ResponseMessage deleteByOrderId(Long orderId);
}
