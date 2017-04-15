package com.jamie.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.modle.ReceivingOrder;

public interface ReceivingOrderDao extends JpaRepository<ReceivingOrder,Long>{
	
}
