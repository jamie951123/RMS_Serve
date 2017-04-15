package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.ReceivingItemDao;
import com.jamie.rms.modle.ReceivingItem;

@Service
public class ReceivingItemServiceImpl implements ReceivingItemService{

	@Autowired
	private ReceivingItemDao receivingItemDao;
	@Override
	public List<ReceivingItem> findAll() {
		// TODO Auto-generated method stub
		return receivingItemDao.findAll();
	}

}
