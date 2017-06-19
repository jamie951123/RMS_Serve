package com.jamie.rms.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
import com.google.gson.reflect.TypeToken;
import com.jamie.rms.model.Product;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.searchcriteria.object.ReceivingItemSearchObject;
import com.jamie.rms.service.ReceivingItemService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/receiving/item")
@Controller
public class ReceivingItemController {

	Logger log = LoggerFactory.getLogger(ReceivingItemController.class);
	
	@Autowired 
	private ReceivingItemService receivingItemService;
	
	
	//Find
	@RequestMapping(value = "/findAll")
	public @ResponseBody List<ReceivingItem> findAll(){
		List<ReceivingItem> receivingItem = receivingItemService.findAll();
		log.info("getReceivingItem :" + receivingItem);
		return receivingItem;
	}
	
	@RequestMapping(value = "/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingItem> findByPartyId(@RequestBody String receivingItemSearchObject_json){
		log.info("[ReceivingItem]-[findByPartyId]-User Request(JSON) : "+ receivingItemSearchObject_json);
		ReceivingItemSearchObject receivingItemSearchObject = new ReceivingItemSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingItemSearchObject = gson.fromJson(receivingItemSearchObject_json, ReceivingItemSearchObject.class);
		}catch (Exception e){
			
		}
		log.info("[ReceivingItem]-[findByPartyId]-User Request(GSON) : "+ receivingItemSearchObject);
		if(receivingItemSearchObject != null && ObjectUtil.isNotNullEmpty(receivingItemSearchObject.getPartyId())){
			List<ReceivingItem> receivingItem = receivingItemService.findByPartyId(receivingItemSearchObject.getPartyId());	
			log.info("[ReceivingItem]-[Response]-findByPartyId :" + receivingItem);
			return receivingItem;
		}
		log.error("[ReceivingItem]-[Error]-findByPartyId : Serve response is empty");
		return null;
	}
	
	@RequestMapping(value = "/findByReceivingID",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingItem findByReceivingID(@RequestBody String receivingItemSearchObject_json){
		log.info("[ReceivingItem]-[findByReceivingID]-User Request(JSON) : "+ receivingItemSearchObject_json);
		ReceivingItemSearchObject receivingItemSearchObject = new ReceivingItemSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingItemSearchObject = gson.fromJson(receivingItemSearchObject_json, ReceivingItemSearchObject.class);
		}catch (Exception e){
			
		}
		log.info("[ReceivingItem]-[findByReceivingID]-User Request(GSON) : "+ receivingItemSearchObject);
		if(receivingItemSearchObject != null && receivingItemSearchObject.getId() != null){
			ReceivingItem receivingItem = receivingItemService.findByReceivingID(receivingItemSearchObject.getId());
			log.info("[ReceivingItem]-[Response]-findByPartyId :" + receivingItem);
			return receivingItem;
		}
		log.error("[ReceivingItem]-[Error]-findByReceivingID : Serve response is empty");
		return null;
	}
	
	//Update
	@RequestMapping(value = "/updateOrderIdNullByOrderId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage updateOrderIdNullByOrderId(@RequestBody String receivingOrder_json){
		log.info("[ReceivingItem]-[updateOrderIdNullByOrderId]-User Request(JSON) : "+ receivingOrder_json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(receivingOrder_json, ReceivingOrder.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingItem]-[updateOrderIdNullByOrderId]-User Request(GSON) : "+ receivingOrder);
		if(receivingOrder != null && receivingOrder.getOrderId() != null){
			ResponseMessage responseMessage =  receivingItemService.updateOrderIdNullByOrderId(receivingOrder.getOrderId());
			log.info("[ReceivingItem]-[updateOrderIdNullByOrderId]-[Response] :" + responseMessage);
			return responseMessage;
		}
		return null;
	}
	
	//Save
	@RequestMapping(value = "/saves",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingItem> saves(@RequestBody String receivingItems_json){
		log.info("[ReceivingItem]-[saves]-User Request(JSON) : "+ receivingItems_json);
		List<ReceivingItem> receivingItems = new ArrayList<ReceivingItem>();
		Type listType = new TypeToken<List<ReceivingItem>>() {}.getType();
		try{
			Gson gson = GsonUtil.getGson();
			receivingItems = gson.fromJson(receivingItems_json, listType);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		log.info("[ReceivingItem]-[saves]-User Request(GSON) : "+ receivingItems);
		List<ReceivingItem> result = new ArrayList<>();
		if(receivingItems != null && !receivingItems.isEmpty()){
			result = receivingItemService.saves(receivingItems);
		}
		log.info("[ReceivingItem]-[saves]-User Request(result) : "+ result);
		return result;
	}
	
	@RequestMapping(value = "/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingItem save(@RequestBody String receivingItem_json){
		log.info("[ReceivingItem]-[save]-User Request(JSON) : "+ receivingItem_json);
		ReceivingItem receivingItem = new ReceivingItem();
		try{
			Gson gson = GsonUtil.getGson();
			receivingItem = gson.fromJson(receivingItem_json, ReceivingItem.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingItem]-[save]-User Request(GSON) : "+ receivingItem);
		ReceivingItem result = new ReceivingItem();
		if(receivingItem != null && receivingItem.getProductId() != null){
			result = receivingItemService.save(receivingItem);
		}
		log.info("[ReceivingItem]-[save]-User Request(result) : "+ result);
		return result;
	}
	
	//Delete
	@RequestMapping(value = "/deleteByProductId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage deleteByProductId(@RequestBody String product_json){
		log.info("[ReceivingItem]-[deleteByProductId]-User Request(JSON) : "+ product_json);
		Product product = new Product();
		try{
			Gson gson = GsonUtil.getGson();
			product = gson.fromJson(product_json, Product.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingItem]-[deleteByProductId]-User Request(GSON) : "+ product);
		if(product != null && product.getProductId() != null){
			ResponseMessage responseMessage =  receivingItemService.deleteByProductId(product.getProductId());
			log.info("[ReceivingItem]-[deleteByProductId]-[Response] :" + responseMessage);
			return responseMessage;
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteByOrderId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage deleteByOrderId(@RequestBody String receivingOrder_json){
		log.info("[ReceivingItem]-[deleteByOrderId]-User Request(JSON) : "+ receivingOrder_json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(receivingOrder_json, ReceivingOrder.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingItem]-[deleteByOrderId]-User Request(GSON) : "+ receivingOrder);
		if(receivingOrder != null && receivingOrder.getOrderId() != null){
			ResponseMessage responseMessage =  receivingItemService.deleteByOrderId(receivingOrder.getOrderId());
			log.info("[ReceivingItem]-[deleteByOrderId]-[Response] :" + responseMessage);
			return responseMessage;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(@RequestBody String receivingItem_json){
		log.info("[ReceivingItem]-[delete]-User Request(JSON) : "+ receivingItem_json);
		ReceivingItem receivingItem = new ReceivingItem();
		try{
			Gson gson = GsonUtil.getGson();
			receivingItem = gson.fromJson(receivingItem_json, ReceivingItem.class);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			log.info("[ReceivingItem]-[delete]-User Request(GSON) : "+ receivingItem);
		}
		if(receivingItem != null && receivingItem.getReceivingId() != null){
			ResponseMessage responseMessage =  receivingItemService.delete(receivingItem);
			log.info("[ReceivingItem]-[delete]-[Response] :" + responseMessage);
			return responseMessage;
		}
		log.info("[ReceivingItem]-[delete]-[Response]-[ERROR] : The receivingItem is empty");
		return null;

	}
	
	
}
