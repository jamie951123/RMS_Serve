package com.jamie.rms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.service.DeliveryOrderService;

@RequestMapping(value = "rms/delivery/order")
@Controller
public class DeliveryOrderController {
	Logger log = LoggerFactory.getLogger(DeliveryOrderController.class);
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<DeliveryOrder> findAll(){
		List<DeliveryOrder> deliveryOrder = deliveryOrderService.findAll();
		log.info("[DeliveryOrder]-[findAll]-User Response() : "+ deliveryOrder);
		return deliveryOrder;
	}
	
}
