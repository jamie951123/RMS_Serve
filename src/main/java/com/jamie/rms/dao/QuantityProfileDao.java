package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.QuantityProfile;

@Repository
@Transactional
public interface QuantityProfileDao extends JpaRepository<QuantityProfile,Long>{

	List<QuantityProfile> findByPartyId(String partyId);
	
	@Modifying(clearAutomatically = true)
	@Query("update QuantityProfile set quantityUnit = ?3 where quantityId = ?1 and partyId = ?2")
	int updateQtyByQuantityIdAndPartyIdAndQtyUnit(Long quantityId,String partyId,String qtyUnit);
	
}
