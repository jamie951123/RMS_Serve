package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.DeliveryItem;

@Repository
@Transactional
public interface DeliveryItemDao extends JpaRepository<DeliveryItem,Long> {

	
	//Delete
	@Modifying(clearAutomatically = true)
	@Query("delete from DeliveryItem where orderId = ?1")
	int deleteByOrderId(Long orderId);

	@Modifying(clearAutomatically = true)
	@Query("delete from DeliveryItem where receivingId = ?1")
	int deleteByReceivingId(Long receivingId);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from DeliveryItem where receivingId in ?1")
	int deleteByReceivingId(List<Long> receivingIds);
	
}
