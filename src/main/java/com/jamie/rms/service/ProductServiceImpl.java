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
		if(productId == null){
			return null;
		}
		ResponseMessage r = new ResponseMessage();
		r.setRequest(String.valueOf(productId));
		try{
			productDao.delete(productId);
			r.setStatus(ResponseStatus.getSuccessful());
			r.setMessage("The record have been deleted");
		}catch (IllegalArgumentException e){
			r.setStatus(ResponseStatus.getFail());
			r.setMessage("The record do not appear into table");
		}
		return r;
	}
}
