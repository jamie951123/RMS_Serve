package com.jamie.rms.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.ReceivingItemDao;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;

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
	public List<ReceivingItem> saves(List<ReceivingItem> receivingItems) {
		// TODO Auto-generated method stub
		return receivingItemDao.save(receivingItems);
	}
	@Override
	public List<ReceivingItem> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return receivingItemDao.findByPartyId(partyId);
	}
	@Override
	public ReceivingItem findByReceivingID(Long receivingID) {
		// TODO Auto-generated method stub
		return receivingItemDao.findByReceivingID(receivingID);
	}
	@Override
	public ResponseMessage deleteByProductId(Long productId) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(String.valueOf(productId));
			int count = receivingItemDao.deleteByProductId(productId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(count);
			r.setMessage_content("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table");
			r.setMessage_count(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return r;
	}
	@Override
	public ResponseMessage updateOrderIdNullByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(orderId.toString());
			receivingItemDao.updateOrderIdNullByOrderId(orderId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
			r.setMessage_content("The record have been deleted");
		}catch (Exception e){
			r.setMessage_status(ResponseStatus.getFail());
			r.setMessage_content("The record do not appear into table"); 
			r.setMessage_count(0);
			e.printStackTrace();
		}
		return r;
	}
	@Override
	public ResponseMessage deleteByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(orderId.toString());
			receivingItemDao.deleteByOrderId(orderId);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
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
	public ReceivingItem save(ReceivingItem receivingItem) {
		// TODO Auto-generated method stub
		return receivingItemDao.save(receivingItem);
	}
	@Override
	public ResponseMessage delete(ReceivingItem receivingItem) {
		// TODO Auto-generated method stub
	
		ResponseMessage r = new ResponseMessage();
		try{
			r.setMessage_request(receivingItem.toString());
			receivingItemDao.delete(receivingItem);
			r.setMessage_status(ResponseStatus.getSuccessful());
			r.setMessage_count(1);
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
