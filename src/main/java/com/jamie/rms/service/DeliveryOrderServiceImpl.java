package com.jamie.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.DeliveryOrderDao;
import com.jamie.rms.model.DeliveryOrder;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService{
	Logger log = LoggerFactory.getLogger(DeliveryOrderServiceImpl.class);

	@Autowired
	private DeliveryOrderDao deliveryOrderDao;
	
	@Override
	public List<DeliveryOrder> findAll() {
		// TODO Auto-generated method stub
		return deliveryOrderDao.findAll();
	}

}
