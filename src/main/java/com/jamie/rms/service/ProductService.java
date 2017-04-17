package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.Product;

public interface ProductService {
	List<Product> findAll();
	List<Product> findByPartyId(String partyId);
	Product save(Product product);
}
