package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.ProductDao;
import com.jamie.rms.model.Product;

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
	public int updateQuantityIdNullByWeightIdAndPartyId(Long quantityId, String partyId) {
		// TODO Auto-generated method stub
		return productDao.updateQuantityIdNullByWeightIdAndPartyId(quantityId, partyId);
	}

}
