package com.jamie.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.rms.modle.Product;

public interface ProductDao extends JpaRepository<Product,Long>{

}
