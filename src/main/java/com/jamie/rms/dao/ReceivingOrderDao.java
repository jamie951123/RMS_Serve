package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.ReceivingOrder;

public interface ReceivingOrderDao extends JpaRepository<ReceivingOrder,Long>{
	
	List<ReceivingOrder> findByPartyId(String partyId);
}
