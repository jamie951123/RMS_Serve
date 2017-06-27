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
import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.searchcriteria.object.DeliveryOrderSearchObject;
import com.jamie.rms.service.DeliveryItemService;
import com.jamie.rms.service.DeliveryOrderService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/delivery/order")
@Controller
public class DeliveryOrderController {
	Logger log = LoggerFactory.getLogger(DeliveryOrderController.class);
	
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	
	@Autowired
	private DeliveryItemService deliveryItemService;
	
	@Autowired 
	private DeliveryItemController deliveryItemController;
	
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
			log.info("[DeliveryOrder]-[Response]-findByPartyIdAndStauts :" + deliveryOrder);
			return deliveryOrder;
		}
		return null;
	}
	
	
//	Save  
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/saveOrderAndItem",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody DeliveryOrder saveOrderAndItem(@RequestBody String deliveryOrder_json){
		log.info("[DeliveryOrder]-[saveOrderAndItem]-User Request(JSON) : "+ deliveryOrder_json);
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		try{
			Gson gson = GsonUtil.getGson();
			deliveryOrder = gson.fromJson(deliveryOrder_json, DeliveryOrder.class);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		log.info("[DeliveryOrder]-[saveOrderAndItem]-User Request(GSON) : "+ deliveryOrder);
		try{		
			DeliveryOrder orderResult 		= deliveryOrderService.save(deliveryOrder);
			log.info("[DeliveryOrder]-[saveOrderAndItem]-User Response(DeliveryOrder) : "+ orderResult);
			
			//Save DeliveryItem
			Long orderId = orderResult.getOrderId();
			for(DeliveryItem item :orderResult.getDeliveryItem()){
				item.setOrderId(orderId);
			}
			List<DeliveryItem> itemResult	= deliveryItemService.saves(deliveryOrder.getDeliveryItem());
			log.info("[DeliveryOrder]-[saveOrderAndItem]-User Response(DeliveryItem) : "+ itemResult);
			
			//Save Inventory
//			List<Inventory> inventoryList = inventoryService.saves(receivingItemGetInventory(itemResult));
//			log.info("[DeliveryOrder]-[saveInventory]-User Response(Inventory) : "+ inventoryList);

			log.info("[DeliveryOrder]-[saveOrderAndItem]-User Response(insert Successful) !! ");
			return deliveryOrder;
		}catch (Exception e){
			e.printStackTrace();
			log.error("[DeliveryOrder]-[saveOrderAndItem]-User Response(Error) : Insert Fail !!");
			throw e;
		}
	}
	//Delete
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value ="/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody ResponseMessage delete(@RequestBody String deliveryOrder_json) {	
		log.info("[DeliveryOrder]-[delete]-User Request(JSON) : "+ deliveryOrder_json);
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		try{
			Gson gson = GsonUtil.getGson();
			deliveryOrder = gson.fromJson(deliveryOrder_json, DeliveryOrder.class);		
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		log.info("[DeliveryOrder]-[delete]-User Request(GSON) : "+ deliveryOrder);
		
		ResponseMessage responseMessageOrder = new ResponseMessage();
		
		if(deliveryOrder != null && deliveryOrder.getOrderId() != null){
			//remove (FK) DeliveryItem
			try{
				ResponseMessage responseMessage = deliveryItemController.deleteByOrderId(deliveryOrder_json);
				log.info("[DeliveryOrder]-[delete]-[Remove (FK) DeliveryItem]-User Request(result) : "+ responseMessage);
			}catch (Exception e){
				e.printStackTrace();
				log.error("[DeliveryOrder]-[delete]-[ERROR]-[Remove (FK) DeliveryItem]-User Request(result) : ");
				throw e;
			}
			
			//Delete DeliveryOrder
//			ResponseMessage responseMessage = new ResponseMessage();
			log.error("[DeliveryOrder]-[delete]-[ERROR]-[Start To Delete DeliveryOrder]-User Request(result) : ");

			try{
				responseMessageOrder = deliveryOrderService.delete(deliveryOrder);
				log.info("[DeliveryOrder]-[delete]-User Request(result) : "+ responseMessageOrder);
				return responseMessageOrder;
			}catch (Exception e){
				e.printStackTrace();
				log.error("[DeliveryOrder]-[delete]-[ERROR]-[Remove DeliveryOrder]-User Request(result) : ");

				throw e;
			}
		}
		return responseMessageOrder;

	}
	
	
}
