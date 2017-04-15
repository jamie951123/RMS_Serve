package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.modle.ReceivingItem;

public interface ReceivingItemDao extends JpaRepository<ReceivingItem,Long>{

	List<ReceivingItem> findByPartyId(String partyId);
}
