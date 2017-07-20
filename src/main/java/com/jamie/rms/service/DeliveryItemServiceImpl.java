package com.jamie.rms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.DeliveryItemDao;
import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.Status;
import com.jamie.rms.searchcriteria.object.DeliveryItemSearchObject;

@Service
public class DeliveryItemServiceImpl implements DeliveryItemService{
	Logger log = LoggerFactory.getLogger(DeliveryItemServiceImpl.class);

	@Autowired
	private DeliveryItemDao deliveryItemDao;
	
	
	//Find
	@Override
	public List<DeliveryItem> findAll() {
		// TODO Auto-generated method stub
		return deliveryItemDao.findAll();
	}
	
	@Override
	public List<DeliveryItem> findByPartyIdAndStatus(String partyId, Status status) {
		// TODO Auto-generated method stub
		return deliveryItemDao.findByPartyIdAndItemStatus(partyId,status);
	}

	
	//Save
	
	@Override
	public List<DeliveryItem> saves(List<DeliveryItem> deliveryItem) {
		// TODO Auto-generated method stub
		return deliveryItemDao.save(deliveryItem); 
	}

	@Override
	public ResponseMessage delete(DeliveryItem deliveryItem) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
		r.setMessage_request(String.valueOf(deliveryItem));
			deliveryItemDao.delete(deliveryItem);
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
	public ResponseMessage deletes(List<DeliveryItem> deliveryItems) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
		r.setMessage_request(String.valueOf(deliveryItems));
			deliveryItemDao.delete(deliveryItems);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(deliveryItems.size());
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table");
			r.setMessage_count(0);
		}
		return r;
	}

	@Override
	public ResponseMessage deleteByOrderId(Long deliveryOrderId) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(deliveryOrderId.toString());
			int count = deliveryItemDao.deleteByOrderId(deliveryOrderId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(count);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table"); 
			r.setMessage_count(0);
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ResponseMessage deleteByReceivingId(Long receivingId) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(receivingId.toString());
			int count = deliveryItemDao.deleteByReceivingId(receivingId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(count);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table"); 
			r.setMessage_count(0);
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ResponseMessage deleteByReceivingIds(List<Long> receivingIds) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(receivingIds.toString());
			int count = deliveryItemDao.deleteByReceivingId(receivingIds);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(count);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table"); 
			r.setMessage_count(0);
			e.printStackTrace();
		}
		return r;
	}



}
