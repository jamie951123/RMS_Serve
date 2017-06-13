package com.jamie.rms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.service.DeliveryItemService;

@RequestMapping(value = "rms/delivery/item")
@Controller
public class DeliveryItemController {
	Logger log = LoggerFactory.getLogger(DeliveryItemController.class);

	@Autowired
	private DeliveryItemService deliveryItemService;
	
//	@Autowired
//	private DeliveryItemService deliveryItemService;
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<DeliveryItem> findAll(){
		List<DeliveryItem> deliveryItem = deliveryItemService.findAll();
		log.info("[DeliveryItem]-[findAll]-User Response() : "+ deliveryItem);
		return deliveryItem;
	} 
	
	//
	
}
