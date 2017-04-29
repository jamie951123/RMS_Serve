package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.Status;

public interface InventoryDao extends JpaRepository<Inventory,Long> {

	List<Inventory> findByPartyId(String party);
	
	List<Inventory> findByPartyIdAndStatus(String partyId, Status stauts);

}
