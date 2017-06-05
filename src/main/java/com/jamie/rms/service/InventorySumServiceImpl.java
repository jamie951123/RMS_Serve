package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.InventorySumDao;
import com.jamie.rms.model.InventorySum;
import com.jamie.rms.model.Status;

@Service
public class InventorySumServiceImpl implements InventorySumService{

	@Autowired
	private InventorySumDao inventorySumDao;

	@Override
	public List<InventorySum> findByPartyIdAndStatus(String partyId, Status status) {
		// TODO Auto-generated method stub
		return inventorySumDao.findByPartyIdAndStatus(partyId,status);
	}

	@Override
	public List<InventorySum> findByPartyIdAndStatusOrderByProductId(String partyId, Status status) {
		// TODO Auto-generated method stub
		return inventorySumDao.findByPartyIdAndStatusOrderByProductId(partyId, status);
	}
	
	

}
