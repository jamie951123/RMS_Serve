package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.ReceivingOrderDao;
import com.jamie.rms.modle.ReceivingOrder;

@Service
public class ReceivingOrderServiceImpl implements ReceivingOrderService{

	@Autowired
	private ReceivingOrderDao receivingOrderDao;
	
	@Override
	public List<ReceivingOrder> findAll() {
		// TODO Auto-generated method stub
		return receivingOrderDao.findAll();
	}

	@Override
	public List<ReceivingOrder> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return receivingOrderDao.findByPartyId(partyId);
	}

	@Override
	public ReceivingOrder save(ReceivingOrder receivingOrder) {
		// TODO Auto-generated method stub
		return receivingOrderDao.save(receivingOrder);
	}

}
