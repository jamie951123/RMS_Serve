package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;

public interface DeliveryOrderService {
	//Find
	List<DeliveryOrder> findAll();
	List<DeliveryOrder> findByPartyIdAndStatus(String partyId,Status status);
	
	//Delete
	ResponseMessage delete(DeliveryOrder deliveryOrder);
}
