package com.jamie.rms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.modle.Product;
import com.jamie.rms.service.ProductService;

@RequestMapping(value="/rms/product")
@Controller
public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/findAll")
	public @ResponseBody List<Product> getAllProduct(){
		List<Product> getAllProduct = productService.findAll();
		log.info("getAllProduct :" + getAllProduct);
		return getAllProduct;
	}
	
	@RequestMapping(value="/findByPartyId")
	public @ResponseBody List<Product> findByPartyId(){
		List<Product> products = productService.findByPartyId("ABC.TL");
		log.info("findByPartyId :" + products);
		return products;
	}
}
