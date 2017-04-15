package com.jamie.rms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.modle.ReceivingItem;
import com.jamie.rms.modle.ReceivingOrder;
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
	
	@RequestMapping(value ="getReceivingOrder")
	public @ResponseBody List<ReceivingOrder> getReceivingOrder(){
		List<ReceivingOrder> receivingOrder = receivingOrderService.findAll();
		log.info("getReceivingOrder :" + receivingOrder);
		return receivingOrder;
	}
	
	@RequestMapping(value = "getReceivingItem")
	public @ResponseBody List<ReceivingItem> getReceivingItem(){
		List<ReceivingItem> receivingItem = receivingItemService.findAll();
		log.info("getReceivingItem :" + receivingItem);
		return receivingItem;
	}
	
}
