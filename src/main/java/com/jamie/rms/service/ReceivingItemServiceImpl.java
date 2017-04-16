package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.ReceivingItemDao;
import com.jamie.rms.model.ReceivingItem;

@Service
public class ReceivingItemServiceImpl implements ReceivingItemService{

	@Autowired
	private ReceivingItemDao receivingItemDao;
	@Override
	public List<ReceivingItem> findAll() {
		// TODO Auto-generated method stub
		return receivingItemDao.findAll();
	}
	@Override
	public List<ReceivingItem> save(List<ReceivingItem> receivingItems) {
		// TODO Auto-generated method stub
		return receivingItemDao.save(receivingItems);
	}
	@Override
	public List<ReceivingItem> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return receivingItemDao.findByPartyId(partyId);
	}

}
