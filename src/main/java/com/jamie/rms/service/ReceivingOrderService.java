package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.modle.ReceivingOrder;

public interface ReceivingOrderService {
	List<ReceivingOrder> findAll();
	List<ReceivingOrder> findByPartyId(String partyId);
	ReceivingOrder save(ReceivingOrder receivingOrder);
}
