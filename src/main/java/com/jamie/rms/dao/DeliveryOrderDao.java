package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.Status;


@Repository
@Transactional
public interface DeliveryOrderDao extends JpaRepository<DeliveryOrder,Long> {
	
	//Find
	List<DeliveryOrder> findByPartyIdAndStatus(String partyId,Status status);
	

}
