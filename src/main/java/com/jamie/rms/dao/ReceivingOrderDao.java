package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.Status;

public interface ReceivingOrderDao extends JpaRepository<ReceivingOrder,Long>{
	
	//Find
	List<ReceivingOrder> findByPartyId(String partyId);
	
	List<ReceivingOrder> findByPartyIdAndStatus(String partyId,Status status);
	
	ReceivingOrder findByOrderId(Long orderId);
}
