package com.jamie.rms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.modle.Product;
import com.jamie.rms.modle.ReceivingItem;

public interface ProductDao extends JpaRepository<Product,Long>{

	List<Product> findByPartyId(String partyId);

}
