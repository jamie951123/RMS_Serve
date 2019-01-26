package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.Image;
import com.jamie.rms.model.Status;

@Repository
@Transactional
public interface ImageDao extends JpaRepository<Image,Long> {

	//Find
	Image findByProductId(Long productId);
	
	//Delete
	@Modifying(clearAutomatically = true)
	@Query("delete from Image where productId = ?1")
	int deleteByProductId(Long productId);

	@Modifying(clearAutomatically = true)
	@Query("delete from DeliveryItem where id = ?1")
	int deleteById(Long id);
	
	
}
