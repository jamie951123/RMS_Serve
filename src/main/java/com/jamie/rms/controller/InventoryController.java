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
import com.jamie.rms.model.Inventory;
import com.jamie.rms.model.ReceivingItem;
import com.jamie.rms.searchcriteria.object.InventorySearchObject;
import com.jamie.rms.service.InventoryService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/inventory")
@Controller
public class InventoryController {
	Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<Inventory> findAll(){
		List<Inventory> inventory = inventoryService.findAll();
		log.info("[Inventory]-[findAll]-User Response() : "+ inventory);
		return inventory;
		
	}
	
	@RequestMapping(value ="/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<Inventory> findByPartyId(@RequestBody String json){
		log.info("[Inventory]-[findByPartyId]-User Request(JSON) : "+ json);
		InventorySearchObject inventorySearchObject = new InventorySearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			inventorySearchObject = gson.fromJson(json, InventorySearchObject.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[Inventory]-[findByPartyId]-User Request(GSON) : "+ inventorySearchObject);
		if(inventorySearchObject != null && ObjectUtil.isNotNullEmpty(inventorySearchObject.getPartyId())){
			List<Inventory> inventorys = inventoryService.findByPartyId(inventorySearchObject.getPartyId());	
			log.info("[Inventory]-[Response]-findByPartyId :" + inventorys);
			return inventorys;
		}
		log.warn("[Inventory]-[Error]-findByPartyId : inventorySearchObject is empty");
		return null;
		
	}
	
	@RequestMapping(value ="/findByPartyIdAndStauts",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<Inventory> findByPartyIdAndStauts(@RequestBody String json){
		log.info("[Inventory]-[findByPartyIdAndStauts]-User Request(JSON) : "+ json);
		InventorySearchObject inventorySearchObject = new InventorySearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			inventorySearchObject = gson.fromJson(json, InventorySearchObject.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[Inventory]-[findByPartyIdAndStauts]-User Request(GSON) : "+ inventorySearchObject);
		if(inventorySearchObject != null && ObjectUtil.isNotNullEmpty(inventorySearchObject.getPartyId()) && inventorySearchObject.getStatus() != null){
			List<Inventory> inventorys = inventoryService.findByPartyIdAndStatus(inventorySearchObject.getPartyId(),inventorySearchObject.getStatus());	
			log.info("[Inventory]-[Response]-findByPartyIdAndStauts :" + inventorys);
			return inventorys;
		}
		log.warn("[Inventory]-[Error]-findByPartyIdAndStauts : inventorySearchObject is empty");
		return null;
		
	}
	
	@RequestMapping(value = "/insertInventorys",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<Inventory> insertInventorys(@RequestBody String json){
		log.info("[Inventory]-[insertInventorys]-User Request(JSON) : "+ json);
		List<Inventory> inventorys = new ArrayList<Inventory>();
		Type listType = new TypeToken<List<Inventory>>() {}.getType();
		try{
			Gson gson = GsonUtil.getGson();
			inventorys = gson.fromJson(json, listType);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[Inventory]-[insertInventorys]-User Request(GSON) : "+ inventorys);
		List<Inventory> result = new ArrayList<>();
		if(inventorys != null && !inventorys.isEmpty()){
			result = inventoryService.saves(inventorys);
		}
		log.info("[Inventory]-[insertInventorys]-User Request(result) : "+ result);
		return null;
	}
	
	@RequestMapping(value = "/insertInventory",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Inventory insertInventory(@RequestBody String json){
		log.info("[Inventory]-[insertInventory]-User Request(JSON) : "+ json);
		Inventory inventory = new Inventory();
		try{
			Gson gson = GsonUtil.getGson();
			inventory = gson.fromJson(json, Inventory.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[Inventory]-[insertInventory]-User Request(GSON) : "+ inventory);
		Inventory result = new Inventory();
		if(inventory != null ){
			result = inventoryService.save(inventory);
		}
		log.info("[Inventory]-[insertInventory]-User Request(result) : "+ result);
		return null;
	}
	
	
}
