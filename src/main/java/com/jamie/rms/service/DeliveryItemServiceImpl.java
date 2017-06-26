package com.jamie.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.DeliveryItemDao;
import com.jamie.rms.model.DeliveryItem;

@Service
public class DeliveryItemServiceImpl implements DeliveryItemService{
	Logger log = LoggerFactory.getLogger(DeliveryItemServiceImpl.class);

	@Autowired
	private DeliveryItemDao deliveryItemDao;
	
	@Override
	public List<DeliveryItem> findAll() {
		// TODO Auto-generated method stub
		return deliveryItemDao.findAll();
	}

	@Override
	public List<DeliveryItem> saves(List<DeliveryItem> deliveryItem) {
		// TODO Auto-generated method stub
		return deliveryItemDao.save(deliveryItem); 
	}

}
