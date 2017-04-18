package com.jamie.rms.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.searchcriteria.object.ReceivingSearchObject;
import com.jamie.rms.service.ReceivingItemService;
import com.jamie.rms.service.ReceivingOrderService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/receiving")
@Controller
public class ReceivingController {
	Logger log = LoggerFactory.getLogger(ReceivingController.class);
	
	@Autowired
	private ReceivingOrderService receivingOrderService;
	
	@Autowired 
	private ReceivingItemService receivingItemService;
	
	@RequestMapping(value ="/order/findAll")
	public @ResponseBody List<ReceivingOrder> getReceivingOrder(){
		List<ReceivingOrder> receivingOrder = receivingOrderService.findAll();
		log.info("getReceivingOrder :" + receivingOrder);
		return receivingOrder;
	}
	
	@RequestMapping(value = "/order/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingOrder> orderFindByPartyId(@RequestBody String json){
		log.info("[ReceivingOrder]-[orderFindByPartyId]-User Request(JSON) : "+ json);
		ReceivingSearchObject receivingSearchObject = new ReceivingSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingSearchObject = gson.fromJson(json, ReceivingSearchObject.class);
		}catch (Exception e){
			
		}
		log.info("[ReceivingOrder]-[orderFindByPartyId]-User Request(GSON) : "+ receivingSearchObject);
		if(receivingSearchObject != null && ObjectUtil.isNotNullEmpty(receivingSearchObject.getPartyId())){
			List<ReceivingOrder> receivingOrder = receivingOrderService.findByPartyId(receivingSearchObject.getPartyId());	
			log.info("[ReceivingOrder]-[Response]-orderFindByPartyId :" + receivingOrder);
			return receivingOrder;
		}
		log.warn("[ReceivingOrder]-[Error]-orderFindByPartyId : productSearchObject is empty");
		return null;
	}
	
	@RequestMapping(value = "/order/insertReceivingOrder",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingOrder insertReceivingOrder(@RequestBody String json){
		
		ReceivingOrder testInsert = new ReceivingOrder();
		testInsert.setPartyId("JAMES.TL");
		testInsert.setItemQty(1);
		testInsert.setCreateDate(new Date());
		
		ReceivingOrder receivingOrder = receivingOrderService.save(testInsert);
		return receivingOrder;
	}
	
	@RequestMapping(value = "/item/findAll")
	public @ResponseBody List<ReceivingItem> getReceivingItem(){
		List<ReceivingItem> receivingItem = receivingItemService.findAll();
		log.info("getReceivingItem :" + receivingItem);
		return receivingItem;
	}
	
	@RequestMapping(value = "/item/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingItem> itemFindByPartyId(@RequestBody String json){
		log.info("[ReceivingItem]-[itemFindByPartyId]-User Request(JSON) : "+ json);
		ReceivingSearchObject receivingSearchObject = new ReceivingSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingSearchObject = gson.fromJson(json, ReceivingSearchObject.class);
		}catch (Exception e){
			
		}
		log.info("[ReceivingItem]-[itemFindByPartyId]-User Request(GSON) : "+ receivingSearchObject);
		if(receivingSearchObject != null && ObjectUtil.isNotNullEmpty(receivingSearchObject.getPartyId())){
			List<ReceivingItem> receivingItem = receivingItemService.findByPartyId(receivingSearchObject.getPartyId());	
			log.info("[ReceivingItem]-[Response]-orderFindByPartyId :" + receivingItem);
			return receivingItem;
		}
		log.error("[ReceivingItem]-[Error]-itemFindByPartyId : Serve response is empty");
		return null;
	}
	
	@RequestMapping(value = "/item/insertReceivingItem",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingItem> insertReceivingItem(@RequestBody String json){
		
		
		List<ReceivingItem> receivingItem = new ArrayList<>();
		ReceivingItem item = new ReceivingItem();
		item.setPartyId("JAMES.TL");
		item.setOrderId(Long.valueOf(1));
		receivingItem.add(item);
		List<ReceivingItem> receivingItems = receivingItemService.save(receivingItem);
		return receivingItems;
	}
}
