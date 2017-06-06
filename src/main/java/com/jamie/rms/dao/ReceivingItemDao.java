package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.ReceivingItem;

@Repository
@Transactional
public interface ReceivingItemDao extends JpaRepository<ReceivingItem,Long>{

	List<ReceivingItem> findByPartyId(String partyId);
	ReceivingItem findByReceivingID(Long receivingID);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from ReceivingItem where productId = ?1")
	int deleteByProductId(Long productId);
	
}
