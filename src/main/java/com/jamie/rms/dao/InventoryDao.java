package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.Status;

@Repository
@Transactional
public interface InventoryDao extends JpaRepository<Inventory,Long> {

	List<Inventory> findByPartyId(String partyId);
	
	List<Inventory> findByPartyIdAndStatus(String partyId, Status stauts);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from Inventory where productId = ?1")
	int deleteByProductId(Long productId);
}
