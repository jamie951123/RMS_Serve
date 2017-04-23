package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.QuantityProfile;

public interface QuantityProfileDao extends JpaRepository<QuantityProfile,Long>{

	List<QuantityProfile> findByPartyId(String partyId);
}
