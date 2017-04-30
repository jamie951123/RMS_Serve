package com.jamie.rms.controller;

import java.lang.reflect.Type;
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
import com.google.gson.reflect.TypeToken;
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.model.ReceivingOrder;
import com.jamie.rms.model.ReceivingOrderAndItemContainer;
import com.jamie.rms.searchcriteria.object.ReceivingSearchObject;
import com.jamie.rms.service.InventoryService;
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
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(value ="/order/findAll")
	public @ResponseBody List<ReceivingOrder> getReceivingOrder(){
		List<ReceivingOrder> receivingOrder = receivingOrderService.findAll();
		log.info("[ReceivingOrder]-[getReceivingOrder]-User Response() : "+ receivingOrder);
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
		log.info("[ReceivingOrder]-[insertReceivingOrder]-User Request(JSON) : "+ json);
		ReceivingOrder receivingOrder = new ReceivingOrder();
		try{
			Gson gson = GsonUtil.getGson();
			receivingOrder = gson.fromJson(json, ReceivingOrder.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingOrder]-[insertReceivingOrder]-User Request(GSON) : "+ receivingOrder);
		ReceivingOrder result = new ReceivingOrder();
		if(receivingOrder != null){
			result = receivingOrderService.save(receivingOrder);
		}
		log.info("[ReceivingOrder]-[insertReceivingOrder]-User Request(result) : "+ result);
		return result;
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
		log.info("[ReceivingItem]-[insertReceivingItem]-User Request(JSON) : "+ json);
		List<ReceivingItem> receivingItems = new ArrayList<ReceivingItem>();
		Type listType = new TypeToken<List<ReceivingItem>>() {}.getType();
		try{
			Gson gson = GsonUtil.getGson();
			receivingItems = gson.fromJson(json, listType);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		log.info("[ReceivingItem]-[insertReceivingItem]-User Request(GSON) : "+ receivingItems);
		List<ReceivingItem> result = new ArrayList<>();
		if(receivingItems != null && !receivingItems.isEmpty()){
			result = receivingItemService.save(receivingItems);
		}
		log.info("[ReceivingItem]-[insertReceivingItem]-User Request(result) : "+ result);
		return result;
	}
	
	@RequestMapping(value = "/orderitem/saveOrderAndItem",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ReceivingOrderAndItemContainer saveOrderAndItem(@RequestBody String json){
		log.info("[ReceivingOrderAndItemContainer]-[saveOrderAndItem]-User Request(JSON) : "+ json);
		ReceivingOrderAndItemContainer container = new ReceivingOrderAndItemContainer();
		try{
			Gson gson = GsonUtil.getGson();
			container = gson.fromJson(json, ReceivingOrderAndItemContainer.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("[ReceivingOrderAndItemContainer]-[saveOrderAndItem]-User Request(GSON) : "+ container);
		List<ReceivingOrderAndItemContainer> result = new ArrayList<>();
		try{		
			if(container != null){
				ReceivingOrder receivingOrder 		= receivingOrderService.save(container.getReceivingOrderModel());
				log.info("[ReceivingOrderAndItemContainer]-[saveOrderAndItem]-User Response(ReceivingOrder) : "+ receivingOrder);
				Long orderId = receivingOrder.getOrderId();
				for(ReceivingItem item :container.getReceivingItemModelList()){
					item.setOrderId(orderId);
				}
				List<ReceivingItem> receivingItem	= receivingItemService.save(container.getReceivingItemModelList());
				log.info("[ReceivingOrderAndItemContainer]-[saveOrderAndItem]-User Response(ReceivingItem) : "+ receivingItem);
				List<Inventory> inventoryList = inventoryService.saves(receivingItemGetInventory(receivingItem));
				log.info("[ReceivingOrderAndItemContainer]-[saveInventory]-User Response(Inventory) : "+ inventoryList);

			}
			log.info("[ReceivingOrderAndItemContainer]-[saveOrderAndItem]-User Response(insert Successful) !! ");
			return container;
		}catch (Exception e){
			e.printStackTrace();
			log.info("[ReceivingItem]-[insertReceivingItem]-User Response(Error) : Insert Fail !!");
		}
		return null;
		
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
