package com.jamie.rms.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jamie.rms.model.Product;
import com.jamie.rms.searchcriteria.object.ProductSearchObject;
import com.jamie.rms.service.ProductService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value="/rms/product")
@Controller
public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/findAll")
	public @ResponseBody List<Product> getAllProduct(){
		List<Product> getAllProduct = productService.findAll();
		log.info("[Product]-[findAll]-[Response] :" + getAllProduct);
		return getAllProduct;
	}
	
	@RequestMapping(value="/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<Product> findByPartyId(@RequestBody String json){
		log.info("[Product]-[findByPartyId]-User Request(JSON) : "+ json);
		ProductSearchObject productSearchObject = new ProductSearchObject();
		try{
			Gson gson = new Gson();
			productSearchObject = gson.fromJson(json, ProductSearchObject.class);
		}catch (Exception e){
			log.error("[Product]-[findByPartyId]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[findByPartyId]-User Request(GSON) : " + productSearchObject);
		}
		
		if(productSearchObject != null && ObjectUtil.isNotNullEmpty(productSearchObject.getPartyId())){
			List<Product> products = productService.findByPartyId(productSearchObject.getPartyId());
			log.info("[Product]-[Response]-findByPartyId :" + products);
			return products;
		}
		log.warn("[Product]-[Error]-findByPartyId : productSearchObject is empty");
		return null;
	}


	@RequestMapping(value="/insertProduct",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Product insertProduct(@RequestBody String json){
		log.info("[Product]-[insertProduct]-User Request(JSON) : "+ json);
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(json,Product.class);
		}catch(Exception e){
			e.printStackTrace();
			log.error("[Product]-[insertProduct]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[insertProduct]-User Request(GSON) : " + product);
		}
		
		if(product != null){
			Product response = productService.save(product);
			log.info("[Product]-[insertProduct]-insertProduct-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-insertProduct : insertProduct Wrong!!");
		return null;
	}
}
