package com.jamie.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.DeliveryOrderDao;
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;

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

	@Override
	public List<DeliveryOrder> findByPartyIdAndStatus(String partyId,Status status) {
		// TODO Auto-generated method stub
		return deliveryOrderDao.findByPartyIdAndStatus( partyId,status);
	}

	@Override
	public ResponseMessage delete(DeliveryOrder deliveryOrder) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
		r.setMessage_request(String.valueOf(deliveryOrder));
		deliveryOrderDao.delete(deliveryOrder);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table");
			r.setMessage_count(0);
		}
		return r;
	}

	@Override
	public DeliveryOrder save(DeliveryOrder deliveryOrder) {
		// TODO Auto-generated method stub
		return deliveryOrderDao.saveAndFlush(deliveryOrder); 
	}

	
}
