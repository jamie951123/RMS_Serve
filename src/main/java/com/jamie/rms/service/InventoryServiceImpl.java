package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.InventoryDao;
import com.jamie.rms.model.Inventory;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryDao inventoryDao;
	
	
	@Override
	public List<Inventory> findAll() {
		// TODO Auto-generated method stub
		return inventoryDao.findAll();
	}

	@Override
	public List<Inventory> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return inventoryDao.findByPartyId(partyId);
	}

	@Override
	public Inventory save(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryDao.save(inventory);
	}

}
