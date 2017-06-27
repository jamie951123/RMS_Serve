package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.Status;


public interface DeliveryOrderDao extends JpaRepository<DeliveryOrder,Long> {
	
	//Find
	List<DeliveryOrder> findByPartyIdAndStatus(String partyId,Status status);
	

}
