package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.InventoryDao;
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.ResponseMessage;
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
	public List<Inventory> findByPartyIdAndStatus(String partyId, Status stauts) {
		// TODO Auto-generated method stub
		return inventoryDao.findByPartyIdAndStatus(partyId, stauts);
	}

	@Override
	public List<Inventory> findByPartyIdAndStatusOrderByProductIdAsc(String partyId, Status stauts) {
		// TODO Auto-generated method stub
		return inventoryDao.findByPartyIdAndStatusOrderByProductIdAsc(partyId,stauts);
	}
	
//	@Override
//	public Inventory save(Inventory inventory) {
//		// TODO Auto-generated method stub
//		return inventoryDao.save(inventory);
//	}

//	@Transactional(rollbackFor = Exception.class)
//	@Override
//	public List<Inventory> saves(List<Inventory> inventorys) {
//		// TODO Auto-generated method stub
//		try{
//			return inventoryDao.save(inventorys);
//		}catch(Exception e){
//			throw e;
//		}
//	}
//
//	@Override
//	public ResponseMessage deleteByProductId(Long productId) {
//		// TODO Auto-generated method stub
//		if(productId == null){
//			return null;
//		}
//		ResponseMessage r = new ResponseMessage();
//		r.setMessage_request(String.valueOf(productId));
//		try{
//			int count = inventoryDao.deleteByProductId(productId);
//			r.setMessage_status(ResponseStatus.getSuccessful());
//			r.setMessage_count(count);
//			r.setMessage_content("The record have been deleted");
//		}catch (IllegalArgumentException e){
//			r.setMessage_status(ResponseStatus.getFail());
//			r.setMessage_content("The record do not appear into table");
//			r.setMessage_count(0);
//		}
//		return r;
//	}
//
//	@Override
//	public ResponseMessage deleteByReceivingItemId(Long receivingItemID) {
//		// TODO Auto-generated method stub
//		ResponseMessage r = new ResponseMessage();
//		r.setMessage_request(String.valueOf(receivingItemID));
//		try{
//			int count = inventoryDao.deleteByReceivingItemId(receivingItemID);
//			r.setMessage_status(ResponseStatus.getSuccessful());
//			r.setMessage_count(count);
//			r.setMessage_content("The record have been deleted");
//		}catch (IllegalArgumentException e){
//			r.setMessage_status(ResponseStatus.getFail());
//			r.setMessage_content("The record do not appear into table");
//			r.setMessage_count(0);
//		}
//		return r;
//	}

	

}
