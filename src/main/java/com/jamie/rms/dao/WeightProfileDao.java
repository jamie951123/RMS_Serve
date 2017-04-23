package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.model.WeightProfile;

public interface WeightProfileDao extends JpaRepository<WeightProfile,Long>{

	List<WeightProfile> findByPartyId (String partyId);
}
