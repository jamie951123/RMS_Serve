package com.jamie.rms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.service.ReceivingItemService;
import com.jamie.rms.service.ReceivingOrderService;

@RequestMapping(value = "rms/receiving")
@Controller
public class ReceivingController {
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
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
	
	@RequestMapping(value = "/order/findByPartyId")
	public @ResponseBody List<ReceivingOrder> orderFindByPartyId(){
		List<ReceivingOrder> receivingOrder = receivingOrderService.findByPartyId("JAMES.TL");
		return receivingOrder;
	}
	
	@RequestMapping(value = "/order/insertReceivingOrder")
	public @ResponseBody ReceivingOrder insertReceivingOrder(){
		
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
	
	@RequestMapping(value = "/item/findByPartyId")
	public @ResponseBody List<ReceivingItem> itemFindByPartyId(){
		List<ReceivingItem> receivingItem = receivingItemService.findByPartyId("ABC.TL");
		return receivingItem;
	}
	
	@RequestMapping(value = "/item/insertReceivingItem")
	public @ResponseBody List<ReceivingItem> insertReceivingItem(){
		List<ReceivingItem> receivingItem = new ArrayList<>();
		ReceivingItem item = new ReceivingItem();
		item.setPartyId("JAMES.TL");
		item.setOrderId(Long.valueOf(1));
		receivingItem.add(item);
		List<ReceivingItem> receivingItems = receivingItemService.save(receivingItem);
		return receivingItems;
	}
}
