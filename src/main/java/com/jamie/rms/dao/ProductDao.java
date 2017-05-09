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

	List<Product> findByPartyId(String partyId);
	
//	@Query("from product where weightId = ?1 and partyId =?2")
//	@Query("update ASNLineItem set productGroupId = null where productGroupId = ?1")
	
	@Modifying(clearAutomatically = true)
	@Query("update Product set weightId = null where weightId = ?1 and partyId = ?2")
	int updateWeightIdNullByWeightIdAndPartyId(Long weightId,String partyId);
}
