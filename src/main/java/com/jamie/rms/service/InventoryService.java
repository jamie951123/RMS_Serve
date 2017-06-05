package com.jamie.rms.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.InventorySum;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;

public interface InventoryService {

	List<Inventory> findAll();
	
	List<Inventory> findByPartyId(String partyId);
	
	List<Inventory> findByPartyIdAndStatus(String partyId, Status stauts);
	
	Inventory save(Inventory inventory);
	
	List<Inventory> saves(List<Inventory> inventory);
	
	ResponseMessage deleteByProductId (Long productId);
}
