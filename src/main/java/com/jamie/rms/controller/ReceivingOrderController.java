package com.jamie.rms.controller;

import java.util.ArrayList;
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
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.searchcriteria.object.ReceivingOrderSearchObject;
import com.jamie.rms.service.InventoryService;
import com.jamie.rms.service.ReceivingItemService;
import com.jamie.rms.service.ReceivingOrderService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/receiving/order")
@Controller
public class ReceivingOrderController {

	Logger log = LoggerFactory.getLogger(ReceivingOrderController.class);

	
	@Autowired
	private ReceivingOrderService receivingOrderService;
	
	@Autowired
	private ReceivingItemController receivingItemController;
	
	@Autowired 
	private ReceivingItemService receivingItemService;
	
	@Autowired
	private InventoryService inventoryService;
	
	//Find
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<ReceivingOrder> findAll(){
		List<ReceivingOrder> receivingOrder = receivingOrderService.findAll();
		log.info("[ReceivingOrder]-[getReceivingOrder]-User Response() : "+ receivingOrder);
		return receivingOrder;
	}
	
	@RequestMapping(value = "/findByOrderId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingOrder findByOrderId(@RequestBody String receivingSearchObject_json){
		log.info("[ReceivingOrder]-[findByOrderId]-User Request(JSON) : "+ receivingSearchObject_json);
		ReceivingOrderSearchObject receivingSearchObject = new ReceivingOrderSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingSearchObject = gson.fromJson(receivingSearchObject_json, ReceivingOrderSearchObject.class);
		}catch (Exception e){
			log.error("[ReceivingOrder]-[findByOrderId]-[Error] : Create GSON Error");
		}finally{
			log.info("[ReceivingOrder]-[findByOrderId]-User Request(GSON) : " + receivingSearchObject);
		}
		
		if(receivingSearchObject != null && receivingSearchObject.getId() != null){
			ReceivingOrder receivingOrder = receivingOrderService.findByOrderId(receivingSearchObject.getId());
			log.info("[ReceivingOrder]-[Response]-findByOrderId :" + receivingOrder);
			return receivingOrder;
		}
		
		log.warn("[ReceivingOrder]-[Error]-findByOrderId : receivingSearchObject is empty");
		return null;
	}

	@RequestMapping(value = "/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingOrder> findByPartyId(@RequestBody String receivingSearchObject_json){
		log.info("[ReceivingOrder]-[findByPartyId]-User Request(JSON) : "+ receivingSearchObject_json);
		ReceivingOrderSearchObject receivingSearchObject = new ReceivingOrderSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingSearchObject = gson.fromJson(receivingSearchObject_json, ReceivingOrderSearchObject.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingOrder]-[findByPartyId]-User Request(GSON) : "+ receivingSearchObject);
		if(receivingSearchObject != null && ObjectUtil.isNotNullEmpty(receivingSearchObject.getPartyId())){
			List<ReceivingOrder> receivingOrder = receivingOrderService.findByPartyId(receivingSearchObject.getPartyId());	
			log.info("[ReceivingOrder]-[findByPartyId]-[Response] :" + receivingOrder);
			return receivingOrder;
		}
		log.warn("[ReceivingOrder]-[findByPartyId]-[Error] : productSearchObject is empty");
		return null;
	}
	
	@RequestMapping(value = "/findByPartyIdAndStatus",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<ReceivingOrder> findByPartyIdAndStatus(@RequestBody String receivingSearchObject_json){
		log.info("[ReceivingOrder]-[findByPartyIdAndStatus]-User Request(JSON) : "+ receivingSearchObject_json);
		ReceivingOrderSearchObject receivingSearchObject = new ReceivingOrderSearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			receivingSearchObject = gson.fromJson(receivingSearchObject_json, ReceivingOrderSearchObject.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingOrder]-[findByPartyIdAndStatus]-User Request(GSON) : "+ receivingSearchObject);
		if(receivingSearchObject != null && ObjectUtil.isNotNullEmpty(receivingSearchObject.getPartyId()) && receivingSearchObject.getStatus() != null){
			List<ReceivingOrder> receivingOrder = receivingOrderService.findByPartyIdAndStatus(receivingSearchObject.getPartyId(),receivingSearchObject.getStatus());	
			log.info("[ReceivingOrder]-[findByPartyIdAndStatus]-[Response] :" + receivingOrder);
			return receivingOrder;
		}
		log.warn("[ReceivingOrder]-[findByPartyIdAndStatus]-[Error] : productSearchObject is empty");
		return null;
	}
	
	//Save
	@RequestMapping(value = "/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingOrder save(@RequestBody String receivingOrder_json){
		log.info("[ReceivingOrder]-[save]-User Request(JSON) : "+ receivingOrder_json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(receivingOrder_json, ReceivingOrder.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingOrder]-[save]-User Request(GSON) : "+ receivingOrder);
		ReceivingOrder result = new ReceivingOrder();
		if(receivingOrder != null){
			result = receivingOrderService.save(receivingOrder);
		}
		log.info("[ReceivingOrder]-[save]-User Request(result) : "+ result);
		return result;
	}
	
	//Updata
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(@RequestBody String receivingOrder_json){
		log.info("[ReceivingOrder]-[delete]-User Request(JSON) : "+ receivingOrder_json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(receivingOrder_json, ReceivingOrder.class);
		}catch (Exception e){
			e.printStackTrace();
			log.error("[ReceivingOrder]-[delete]-[ERROR]-[json to Gson] : ");
			throw e;
		}
		log.info("[ReceivingOrder]-[delete]-User Request(GSON) : "+ receivingOrder);
		if(receivingOrder != null && receivingOrder.getOrderId() != null){
		//remove (FK) ReceivingItem
			try{
				ResponseMessage responseMessage = receivingItemController.deleteByOrderId(receivingOrder_json);
				log.info("[ReceivingOrder]-[delete]-[Remove (FK) ReceivingItem]-User Request(result) : "+ responseMessage);
			}catch (Exception e){
				e.printStackTrace();
				log.error("[ReceivingOrder]-[delete]-[ERROR]-[Remove (FK) ReceivingItem]-User Request(result) : ");
				throw e;
			}
		
		//Delete ReceivingOrder
			try{
				ResponseMessage responseMessage = receivingOrderService.deleteByOrderId(receivingOrder.getOrderId());
				log.info("[ReceivingOrder]-[delete]-User Request(result) : "+ responseMessage);
				return responseMessage;
			}catch (Exception e){
				e.printStackTrace();
				log.error("[ReceivingOrder]-[delete]-[ERROR]-[Remove ReceivingOrder]-User Request(result) : ");

				throw e;
			}
		}
		return null;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/saveOrderAndItem",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingOrder saveOrderAndItem(@RequestBody String receivingOrder_json){
		log.info("[ReceivingOrder]-[saveOrderAndItem]-User Request(JSON) : "+ receivingOrder_json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(receivingOrder_json, ReceivingOrder.class);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		log.info("[ReceivingOrder]-[saveOrderAndItem]-User Request(GSON) : "+ receivingOrder);
		
		try{		
			ReceivingOrder orderResult 		= receivingOrderService.save(receivingOrder);
			log.info("[ReceivingOrder]-[saveOrderAndItem]-User Response(ReceivingOrder) : "+ orderResult);
			
			//Save ReceivingItem
			Long orderId = orderResult.getOrderId();
			for(ReceivingItem item :orderResult.getReceivingItem()){
				item.setOrderId(orderId);
			}
			List<ReceivingItem> itemResult	= receivingItemService.saves(receivingOrder.getReceivingItem());
			log.info("[ReceivingOrder]-[saveOrderAndItem]-User Response(ReceivingItem) : "+ itemResult);
			
			//Save Inventory
			List<Inventory> inventoryList = inventoryService.saves(receivingItemGetInventory(itemResult));
			log.info("[ReceivingOrder]-[saveInventory]-User Response(Inventory) : "+ inventoryList);

			log.info("[ReceivingOrder]-[saveOrderAndItem]-User Response(insert Successful) !! ");
			return receivingOrder;
		}catch (Exception e){
			e.printStackTrace();
			log.error("[ReceivingOrder]-[saveOrderAndItem]-User Response(Error) : Insert Fail !!");
			throw e;
		}
		
	}
	
	public List<Inventory> receivingItemGetInventory(List<ReceivingItem> receivingItem){
		 List<Inventory> inventorys = new ArrayList<>();
		for(ReceivingItem rl :receivingItem) {
			Inventory inv = rl.getInventory();
			inventorys.add(inv);
		}
		return inventorys;
	}
	
}
