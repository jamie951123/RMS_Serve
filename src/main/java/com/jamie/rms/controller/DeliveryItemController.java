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
import com.jamie.rms.model.DeliveryItem;
import com.jamie.rms.model.DeliveryOrder;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.service.DeliveryItemService;
import com.jamie.rms.util.GsonUtil;

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
	
	//Delete
	@RequestMapping(value ="/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody ResponseMessage delete(@RequestBody String deliveryItem_json) {	
		log.info("[DeliveryItem]-[delete]-User Request(JSON) : "+ deliveryItem_json);
		DeliveryItem deliveryItem = new DeliveryItem();
		try{
			Gson gson = GsonUtil.getGson();
			deliveryItem = gson.fromJson(deliveryItem_json, DeliveryItem.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[DeliveryItem]-[delete]-User Request(GSON) : "+ deliveryItem);
		
		ResponseMessage responseMessage = new ResponseMessage();
		if(deliveryItem != null){
			responseMessage = deliveryItemService.delete(deliveryItem);	
			log.info("[DeliveryItem]-[Response]-delete :" + responseMessage);
		}
		return responseMessage;
	}
	
		@RequestMapping(value ="/deletes",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
		public @ResponseBody ResponseMessage deletes(@RequestBody String deliveryItems_json) {	
			log.info("[DeliveryItem]-[delete]-User Request(JSON) : "+ deliveryItems_json);
			List<DeliveryItem> deliveryItems = new ArrayList();
			try{
				Gson gson = GsonUtil.getGson();
	            Type listType = new TypeToken<List<DeliveryItem>>() {}.getType();
	            deliveryItems = gson.fromJson(deliveryItems_json, listType);		
			}catch (Exception e){
				e.printStackTrace();
			}
			log.info("[DeliveryItem]-[delete]-User Request(GSON) : "+ deliveryItems);
			
			ResponseMessage responseMessage = new ResponseMessage();
			if(deliveryItems != null){
				responseMessage = deliveryItemService.deletes(deliveryItems);	
				log.info("[DeliveryItem]-[Response]-delete :" + responseMessage);
			}
			return responseMessage;
		}
	
		@RequestMapping(value ="/deleteByOrderId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
		public @ResponseBody ResponseMessage deleteByOrderId(@RequestBody String deliveryOrder_json) {
			log.info("[DeliveryItem]-[deleteByOrderId]-User Request(JSON) : "+ deliveryOrder_json);
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			try{
				Gson gson = GsonUtil.getGson();
				deliveryOrder = gson.fromJson(deliveryOrder_json, DeliveryOrder.class);
			}catch (Exception e){
				e.printStackTrace();
			}
			log.info("[DeliveryItem]-[deleteByOrderId]-User Request(GSON) : "+ deliveryOrder);
			if(deliveryOrder != null && deliveryOrder.getOrderId() != null){
				ResponseMessage responseMessage =  deliveryItemService.deleteByOrderId(deliveryOrder.getOrderId());
				log.info("[DeliveryItem]-[deleteByOrderId]-[Response] :" + responseMessage);
				return responseMessage;
			}
			return null;
		}
		
		@RequestMapping(value ="/deleteByReceivingId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
		public @ResponseBody ResponseMessage deleteByReceivingId(@RequestBody String receivingItem_json) {
			log.info("[DeliveryItem]-[deleteByReceivingId]-User Request(JSON) : "+ receivingItem_json);
			ReceivingItem receivingItem = new ReceivingItem();
			try{
				Gson gson = GsonUtil.getGson();
				receivingItem = gson.fromJson(receivingItem_json, ReceivingItem.class);
			}catch (Exception e){
				e.printStackTrace();
			}
			log.info("[DeliveryItem]-[deleteByReceivingId]-User Request(GSON) : "+ receivingItem_json);
			try{
				ResponseMessage responseMessage =  deliveryItemService.deleteByReceivingId(receivingItem.getReceivingId());
				log.info("[DeliveryItem]-[deleteByReceivingId]-[Response] :" + responseMessage);
				return responseMessage;
			}catch(Exception e){
				e.printStackTrace();
				throw e;
				
			}
		}
		
		@RequestMapping(value ="/deleteByReceivingIds",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
		public @ResponseBody ResponseMessage deleteByReceivingIds(@RequestBody String receivingItems_json) {
			log.info("[DeliveryItem]-[deleteByReceivingIds]-User Request(JSON) : "+ receivingItems_json);
			List<ReceivingItem> receivingItems = new ArrayList<>();
			try{
				Gson gson = GsonUtil.getGson();
	            Type listType = new TypeToken<List<ReceivingItem>>() {}.getType();
				receivingItems = gson.fromJson(receivingItems_json, listType);
			}catch (Exception e){
				e.printStackTrace();
			}
			log.info("[DeliveryItem]-[deleteByReceivingIds]-User Request(GSON) : "+ receivingItems_json);
			if(receivingItems != null && !receivingItems.isEmpty()){
				List<Long> receivingIds = new ArrayList<>();
				for(ReceivingItem r : receivingItems){
					Long receivingId = r.getReceivingId();
					if(receivingId != null){
						receivingIds.add(r.getReceivingId());
					}
				}
				ResponseMessage responseMessage =  deliveryItemService.deleteByReceivingIds(receivingIds);
				log.info("[DeliveryItem]-[deleteByReceivingIds]-[Response] :" + responseMessage);
				return responseMessage;
			}
			return null;
		}
		
		
}
