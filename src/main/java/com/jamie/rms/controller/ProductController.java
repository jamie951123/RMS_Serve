package com.jamie.rms.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jamie.rms.model.Product;
import com.jamie.rms.model.QuantityProfile;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.WeightProfile;
import com.jamie.rms.searchcriteria.object.ProductSearchObject;
import com.jamie.rms.service.ProductService;
import com.jamie.rms.service.ReceivingItemService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value="/rms/product")
@Controller
public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReceivingItemController receivingItemController;
	
//	@Autowired
//	private InventoryController inventoryController;
	
	@Autowired 
	private ReceivingItemService receivingItemService;
	
	
//	Find
	@RequestMapping(value="/findAll")
	public @ResponseBody List<Product> findAll(){
		List<Product> getAllProduct = productService.findAll();
		log.info("[Product]-[findAll]-[Response] :" + getAllProduct);
		return getAllProduct;
	}
	
	@RequestMapping(value="/findByProductId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Product findByProductId(@RequestBody String json){
		log.info("[Product]-[findByPartyId]-User Request(JSON) : "+ json);
		ProductSearchObject productSearchObject = new ProductSearchObject();
		try{
			Gson gson = new Gson();
			productSearchObject = gson.fromJson(json, ProductSearchObject.class);
		}catch (Exception e){
			log.error("[Product]-[findByProductId]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[findByProductId]-User Request(GSON) : " + productSearchObject);
		}
		
		if(productSearchObject != null && productSearchObject.getId() != null){
			Product product = productService.findByProductId(productSearchObject.getId());
			log.info("[Product]-[Response]-findByPartyId :" + product);
			return product;
		}
		log.warn("[Product]-[Error]-findByPartyId : productSearchObject is empty");
		return null;
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

//	Save
	@RequestMapping(value="/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Product save(@RequestBody String json){
		log.info("[Product]-[save]-User Request(JSON) : "+ json);
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(json,Product.class);
		}catch(Exception e){
			e.printStackTrace();
			log.error("[Product]-[save]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[save]-User Request(GSON) : " + product);
		}
		
		if(product != null){
			Product response = productService.save(product);
			log.info("[Product]-[save]-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-[save] : insertProduct Wrong!!");
		return null;
	}
	
//	Save
	@RequestMapping(value="/updateWeightIdNullByWeightIdAndPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Integer updateWeightIdNullByPartyIdAndWeightId(@RequestBody String weightProfile_json){
		log.info("[Product]-[updateWeightIdNullByWeightIdAndPartyId]-User Request(JSON) : "+ weightProfile_json);
		WeightProfile weightProfile = new WeightProfile();
		try{
			Gson gson = GsonUtil.getGson();
			weightProfile = gson.fromJson(weightProfile_json,WeightProfile.class);
		}catch(Exception e){
			e.printStackTrace();
			log.error("[Product]-[updateWeightIdNullByWeightIdAndPartyId]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[updateWeightIdNullByWeightIdAndPartyId]-User Request(GSON) : " + weightProfile);
		}
		
		if(weightProfile != null && weightProfile.getPartyId() != null && weightProfile.getWeightId() != null){
			int response = productService.updateWeightIdNullByWeightIdAndPartyId(weightProfile.getWeightId(), weightProfile.getPartyId());
			log.info("[Product]-[updateWeightIdNullByWeightIdAndPartyId]-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-updateWeightIdNullByWeightIdAndPartyId : UpdateProduct Wrong!!");
		return null;
	}
	
	@RequestMapping(value="/updateQuantityIdNullByQuantityIdAndPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Integer updateQuantityIdNullByQuantityIdAndPartyId(@RequestBody String quantityProfile_json){
		log.info("[Product]-[updateQuantityIdNullByQuantityIdAndPartyId]-User Request(JSON) : "+ quantityProfile_json);
		QuantityProfile quantityProfile = new QuantityProfile();
		try{
			Gson gson = GsonUtil.getGson();
			quantityProfile = gson.fromJson(quantityProfile_json,QuantityProfile.class);
		}catch(Exception e){
			e.printStackTrace();
			log.error("[Product]-[updateQuantityIdNullByQuantityIdAndPartyId]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[updateQuantityIdNullByQuantityIdAndPartyId]-User Request(GSON) : " + quantityProfile);
		}
		
		if(quantityProfile != null && quantityProfile.getPartyId() != null && quantityProfile.getQuantityId() != null){
			int response = productService.updateQuantityIdNullByQuantityIdAndPartyId(quantityProfile.getQuantityId(), quantityProfile.getPartyId());
			log.info("[Product]-[updateQuantityIdNullByQuantityIdAndPartyId]-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-updateQuantityIdNullByQuantityIdAndPartyId : UpdateProduct Wrong!!");
		return null;
	}
	
	@RequestMapping(value="/updateQuantityIdAndWeightIdNullByProductId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Integer updateQuantityIdAndWeightIdNullByProductId(@RequestBody String product_json){
		log.info("[Product]-[updateQuantityIdAndWeightIdNullByProductId]-User Request(JSON) : "+ product_json);
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(product_json, Product.class);
		}catch (Exception e){
			log.error("[Product]-[updateQuantityIdAndWeightIdNullByProductId]-[Error] : Create GSON Error");
		}finally{
			log.info("[Product]-[updateQuantityIdAndWeightIdNullByProductId]-User Request(GSON) : " + product);
		}
		
		if(product != null && product.getProductId() != null){
			int response = productService.updateQuantityIdAndWeightIdNullByProductId(product.getProductId());
			log.info("[Product]-[updateQuantityIdAndWeightIdNullByProductId]-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-updateQuantityIdAndWeightIdNullByProductId : UpdateProduct Wrong!!");
		return null;
	}
	
//	Delete
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/deleteByProductId",produces="application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage deleteByProductId(@RequestBody String product_json){
		log.info("[Product]-[deleteByProductId]-User Request(JSON) : "+ product_json);
		//
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(product_json, Product.class);
		}catch (Exception e){
			log.error("[Product]-[deleteByProductId]-[Error] : Create GSON Error");
			throw e;
		}finally{
			log.info("[Product]-[deleteByProductId]-User Request(GSON) : " + product);
		}
		
		//clear quanlityId and weightId  
		try{
//			this.updateQuantityIdAndWeightIdNullByProductId(product_json);
			receivingItemController.deleteByProductId(product_json);
//			inventoryController.deleteByProductId(product_json);
			log.info("[Product]-[deleteByProductId]-Successful Clear All FK ");
			
		}catch(Exception e){
			throw e;
		}
		
		
		if(product != null && product.getProductId() != null){
			ResponseMessage response = productService.deleteByProductId(product.getProductId());
			log.info("[Product]-[deleteByProductId]-[Response] :" + response);
			return response;
		}
		log.warn("[Product]-[Error]-deleteByProductId : Product is empty");
		return null;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value="/delete",produces="application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(@RequestBody String product_json){
		log.info("[Product]-[delete]-User Request(JSON) : "+ product_json);

		//
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(product_json, Product.class);
		}catch (Exception e){
			log.error("[Product]-[delete]-[Error] : Create GSON Error");
			throw e;
		}finally{
			log.info("[Product]-[delete]-User Request(GSON) : " + product);
		}
		
		try{
			//[ReceivingItem]-findByProductId 
			List<ReceivingItem> receivingItems = receivingItemService.findByProductId(product.getProductId());
			for(ReceivingItem r : receivingItems){
				r.setDeliveryItem(null);
				r.setReceivingOrder(null);
				r.setProduct(null);
			}
			System.out.println("receivingItems :" + receivingItems.toString());
			//Remove ReceivingItem (FK)

			Gson gson = GsonUtil.getGson();
			String receivingItem_json = gson.toJson(receivingItems);
			ResponseMessage responseMessage = receivingItemController.deletes(receivingItem_json);
			log.info("[Product]-[delete]-[ReceivingItem]-[FK]-User Response : " + responseMessage);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		try{
			ResponseMessage response = productService.delete(product);
			log.info("[Product]-[delete]-[Response] :" + response);
			return response;
		}catch(Exception e){
			e.printStackTrace();
		}
		log.warn("[Product]-[delete]-[Error] : Product is empty");
		return null;
	}
	
}
