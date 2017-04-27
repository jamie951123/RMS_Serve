package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.Inventory;

public interface InventoryService {

	List<Inventory> findAll();
	
	List<Inventory> findByPartyId(String partyId);
	
	Inventory save(Inventory inventory);
}
