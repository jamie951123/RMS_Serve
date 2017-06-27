package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.Product;

@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product,Long>,JpaSpecificationExecutor<Product>{

//    Find
	List<Product> findByPartyId(String partyId);
	
	Product findByProductId (Long productId);
	
//	@Query("from product where weightId = ?1 and partyId =?2")
//	@Query("update ASNLineItem set productGroupId = null where productGroupId = ?1")
	
//	Update
	@Modifying(clearAutomatically = true)
	@Query("update Product set weightId = null where weightId = ?1 and partyId = ?2")
	int updateWeightIdNullByWeightIdAndPartyId(Long weightId,String partyId);
	
	@Modifying(clearAutomatically = true)
	@Query("update Product set quantityId = null where quantityId = ?1 and partyId = ?2")
	int updateQuantityIdNullByQuantityIdAndPartyId(Long quantityId,String partyId);

	
	@Modifying(clearAutomatically = true)
	@Query("update Product set quantityId = null, weightId = null where productId = ?1")
	int updateQuantityIdAndWeightIdNullByProductId(Long productId);
	
}
