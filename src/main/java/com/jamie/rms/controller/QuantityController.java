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
import com.jamie.rms.model.QuantityProfile;
import com.jamie.rms.searchcriteria.object.QuantitySearchObject;
import com.jamie.rms.service.QuantityProfileService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/quantity")
@Controller
public class QuantityController {

	Logger log = LoggerFactory.getLogger(QuantityController.class);

	@Autowired 
	private QuantityProfileService quantityProfileService;
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<QuantityProfile> getQuantityProfile(){
		List<QuantityProfile> QuantityProfile = quantityProfileService.findAll();
		log.info("[QuantityProfile]-[findAll]-User Response(JSON) : "+ QuantityProfile);
		return QuantityProfile;
	}
	
	@RequestMapping(value = "/findByPartyId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody List<QuantityProfile> findByPartyId(@RequestBody String json){
		log.info("[QuantityProfile]-[findByPartyId]-User Request(JSON) : "+ json);
		QuantitySearchObject quantitySearchObject = new QuantitySearchObject();
		
		try{
			Gson gson = GsonUtil.getGson();
			quantitySearchObject = gson.fromJson(json, QuantitySearchObject.class);
		}catch (Exception e){
			
		}
		log.info("[QuantityProfile]-[findByPartyId]-User Request(GSON) : "+ quantitySearchObject);
		if(quantitySearchObject != null && ObjectUtil.isNotNullEmpty(quantitySearchObject.getPartyId())){
			List<QuantityProfile> QuantityProfile = quantityProfileService.findByPartyId(quantitySearchObject.getPartyId());	
			log.info("[QuantityProfile]-[Response]-findByPartyId :" + QuantityProfile);
			return QuantityProfile;
		}
		log.warn("[QuantityProfile]-[Error]-findByPartyId : quantitySearchObject is empty");
		return null;
	}
	
	
	
}
