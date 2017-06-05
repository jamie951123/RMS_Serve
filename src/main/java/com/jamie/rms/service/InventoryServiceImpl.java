package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.InventoryDao;
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.InventorySum;
import com.jamie.rms.model.Status;
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

	@Override
	public List<Inventory> findByPartyIdAndStatus(String partyId, Status stauts) {
		// TODO Auto-generated method stub
		return inventoryDao.findByPartyIdAndStatus(partyId, stauts);
	}

	@Override
	public List<Inventory> saves(List<Inventory> inventorys) {
		// TODO Auto-generated method stub
		return inventoryDao.save(inventorys);
	}

	

}
