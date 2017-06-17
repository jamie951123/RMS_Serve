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
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.searchcriteria.object.DeliveryOrderSearchObject;
import com.jamie.rms.searchcriteria.object.InventorySearchObject;
import com.jamie.rms.service.DeliveryOrderService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/delivery/order")
@Controller
public class DeliveryOrderController {
	Logger log = LoggerFactory.getLogger(DeliveryOrderController.class);
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	//Find
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<DeliveryOrder> findAll(){
		List<DeliveryOrder> deliveryOrder = deliveryOrderService.findAll();
		log.info("[DeliveryOrder]-[findAll]-User Response() : "+ deliveryOrder);
		return deliveryOrder;
	}
	
	@RequestMapping(value ="/findByPartyIdAndStauts",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody List<DeliveryOrder> findByPartyIdAndStauts(@RequestBody String json) {	
		log.info("[DeliveryOrder]-[findByPartyIdAndStauts]-User Request(JSON) : "+ json);
		DeliveryOrderSearchObject deliveryOrderSearchObject = new DeliveryOrderSearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			deliveryOrderSearchObject = gson.fromJson(json, DeliveryOrderSearchObject.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[DeliveryOrder]-[findByPartyIdAndStauts]-User Request(GSON) : "+ deliveryOrderSearchObject);
		if(deliveryOrderSearchObject != null && ObjectUtil.isNotNullEmpty(deliveryOrderSearchObject.getPartyId()) && deliveryOrderSearchObject.getStatus() != null){
			List<DeliveryOrder> deliveryOrder = deliveryOrderService.findByPartyIdAndStatus(deliveryOrderSearchObject.getPartyId(),deliveryOrderSearchObject.getStatus());	
			log.info("[DeliveryOrder]-[Response]-findByPartyIdAndStauts :" + deliveryOrderSearchObject);
			return deliveryOrder;
		}
		return null;
	}
	
	//Delete
	
	@RequestMapping(value ="/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody ResponseMessage delete(@RequestBody String deliveryOrder_json) {	
		log.info("[DeliveryOrder]-[delete]-User Request(JSON) : "+ deliveryOrder_json);
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		try{
			Gson gson = GsonUtil.getGson();
			deliveryOrder = gson.fromJson(deliveryOrder_json, DeliveryOrder.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[DeliveryOrder]-[delete]-User Request(GSON) : "+ deliveryOrder);
		if(deliveryOrder != null){
			ResponseMessage responseMessage = deliveryOrderService.delete(deliveryOrder);	
			log.info("[DeliveryOrder]-[Response]-delete :" + responseMessage);
			return responseMessage;
		}
		return null;
	}
	
	
}
