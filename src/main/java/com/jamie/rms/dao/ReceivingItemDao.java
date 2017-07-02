package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.ReceivingItem;

@Repository
@Transactional
public interface ReceivingItemDao extends JpaRepository<ReceivingItem,Long>,
JpaSpecificationExecutor<ReceivingItem>{

	List<ReceivingItem> findByPartyId(String partyId);
	ReceivingItem findByReceivingId(Long receivingID);
	
	//Update
	@Modifying(clearAutomatically = true)
	@Query("update ReceivingItem set orderId = null where orderId = ?1")
	int updateOrderIdNullByOrderId(Long orderId);
	
	@Modifying(clearAutomatically = true)
	@Query("update ReceivingItem set productId = null where productId = ?1")
	int updateProductIdNullByProductId(Long productId);
	
	//Delete
	@Modifying(clearAutomatically = true)
	@Query("delete from ReceivingItem where orderId = ?1")
	int deleteByOrderId(Long orderId);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from ReceivingItem where productId = ?1")
	int deleteByProductId(Long productId);
	
	
}
