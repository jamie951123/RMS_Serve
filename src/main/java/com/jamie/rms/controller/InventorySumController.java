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
import com.jamie.rms.model.InventorySum;
import com.jamie.rms.searchcriteria.object.InventorySearchObject;
import com.jamie.rms.service.InventorySumService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@Controller
@RequestMapping(value = "rms/inventorysum")
public class InventorySumController {
	Logger log = LoggerFactory.getLogger(InventorySumController.class);
	
	@Autowired
	private InventorySumService inventorySumService;
	
	@RequestMapping(value ="/findByPartyIdAndStatus",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<InventorySum> findByPartyIdAndStatus(@RequestBody String json){
		log.info("[InventorySum]-[findByPartyIdAndStatus]-User Request(JSON) : "+ json);
		InventorySearchObject inventorySearchObject = new InventorySearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			inventorySearchObject = gson.fromJson(json, InventorySearchObject.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[InventorySum]-[findByPartyIdAndStatus]-User Request(GSON) : "+ inventorySearchObject);
		if(inventorySearchObject != null && ObjectUtil.isNotNullEmpty(inventorySearchObject.getPartyId()) && inventorySearchObject.getStatus() != null){
			List<InventorySum> inventorySum = inventorySumService.findByPartyIdAndStatus(inventorySearchObject.getPartyId(),inventorySearchObject.getStatus());	
			log.info("[InventorySum]-[Response]-sum_findByPartyIdAndStatus :" + inventorySum);
			return inventorySum;
		}
		log.warn("[InventorySum]-[Error]-findByPartyIdAndStatus : inventorySearchObject is empty");
		return null;
	}
	
	@RequestMapping(value ="/findByPartyIdAndStatusOrderProductId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<InventorySum> findByPartyIdAndStatusOrderProductId(@RequestBody String json){
		log.info("[InventorySum]-[findByPartyIdAndStatusOrderProductId]-User Request(JSON) : "+ json);
		InventorySearchObject inventorySearchObject = new InventorySearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			inventorySearchObject = gson.fromJson(json, InventorySearchObject.class);		
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[InventorySum]-[findByPartyIdAndStatusOrderProductId]-User Request(GSON) : "+ inventorySearchObject);
		if(inventorySearchObject != null && ObjectUtil.isNotNullEmpty(inventorySearchObject.getPartyId()) && inventorySearchObject.getStatus() != null){
			List<InventorySum> inventorySum = inventorySumService.findByPartyIdAndStatusOrderByProductId(inventorySearchObject.getPartyId(),inventorySearchObject.getStatus());	
			log.info("[InventorySum]-[Response]-findByPartyIdAndStatusOrderProductId :" + inventorySum);
			return inventorySum;
		}
		log.warn("[InventorySum]-[Error]-findByPartyIdAndStatusOrderProductId : inventorySearchObject is empty");
		return null;
	}
	
}
