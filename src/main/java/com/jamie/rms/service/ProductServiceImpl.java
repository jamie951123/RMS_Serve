package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.common.ResponseStatus;
import com.jamie.rms.dao.ProductDao;
import com.jamie.rms.model.Product;
import com.jamie.rms.model.ResponseMessage;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}
	@Override
	public List<Product> findByPartyId(String partyId) {
		// TODO Auto-generated method stub
		return productDao.findByPartyId(partyId);
	}
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}
	@Override
	public int updateWeightIdNullByWeightIdAndPartyId(Long weightId,String partyId) {
		// TODO Auto-generated method stub
		return productDao.updateWeightIdNullByWeightIdAndPartyId(weightId, partyId);
//		return null;
	}
	@Override
	public int updateQuantityIdNullByQuantityIdAndPartyId(Long quantityId, String partyId) {
		// TODO Auto-generated method stub
		return productDao.updateQuantityIdNullByQuantityIdAndPartyId(quantityId, partyId);
	}
	@Override
	public Product findByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productDao.findByProductId(productId);
	}
	@Override
	public int updateQuantityIdAndWeightIdNullByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productDao.updateQuantityIdAndWeightIdNullByProductId(productId);
	}
	@Override
	public ResponseMessage deleteByProductId(Long productId){
		// TODO Auto-generated method stub
		ResponseMessage r = new ResponseMessage();
		try{
		r.setMessage_request(String.valueOf(productId));
			productDao.delete(productId);
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
	public ResponseMessage delete(Product product) {
		// TODO Auto-generated method stub
		if(product == null){
			return null;
		}
		ResponseMessage r = new ResponseMessage();
		r.setMessage_request(product.toString());
		try{
			productDao.delete(product);
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
}
