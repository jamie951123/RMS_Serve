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
import com.jamie.rms.model.ResponseMessage;
import com.jamie.rms.model.WeightProfile;
import com.jamie.rms.searchcriteria.object.QuantitySearchObject;
import com.jamie.rms.searchcriteria.object.WeightSearchObject;
import com.jamie.rms.service.WeightProfileService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value = "rms/weight")
@Controller
public class WeightController {

	Logger log = LoggerFactory.getLogger(WeightController.class);
	
	@Autowired
	private WeightProfileService weightProfileService;
	
	@RequestMapping(value ="/findAll")
	public @ResponseBody List<WeightProfile> findAll(){
		List<WeightProfile> weightProfiles = weightProfileService.findAll();
		log.info("[WeightProfile]-[findAll]-User Response(JSON) : "+ weightProfiles);
		return weightProfiles;
	}
	
	@RequestMapping(value = "/findByPartyId")
	public @ResponseBody List<WeightProfile> findByPartyId(@RequestBody String json){
		log.info("[WeightProfile]-[findByPartyId]-User Request(JSON) : "+ json);
		WeightSearchObject weightSearchObject = new WeightSearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			weightSearchObject = gson.fromJson(json, WeightSearchObject.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[WeightProfile]-[findByPartyId]-User Request(GSON) : "+ weightSearchObject);
		if(weightSearchObject != null && ObjectUtil.isNotNullEmpty(weightSearchObject.getPartyId())){
			List<WeightProfile> weightProfiles = weightProfileService.findByPartyId(weightSearchObject.getPartyId());
			log.info("[WeightProfile]-[Response]-findByPartyId :" + weightProfiles);
			return weightProfiles;
		}
		
		log.warn("[WeightProfile]-[Error]-findByPartyId : quantitySearchObject is empty");
		return null;
	}
	
	@RequestMapping(value = "/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(@RequestBody String json){
		log.info("[WeightProfile]-[delete]-User Request(JSON) : "+ json);
		WeightProfile weightProfile = new WeightProfile();
		try{
			Gson gson = GsonUtil.getGson();
			weightProfile = gson.fromJson(json, WeightProfile.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[WeightProfile]-[delete]-User Request(GSON) : "+ weightProfile);
		if(weightProfile != null ){
			ResponseMessage responseMessage = weightProfileService.delete(weightProfile);
			log.info("[ResponseMessage]-[Response]-delete :" + responseMessage);
			return responseMessage;
		}
		
		log.warn("[WeightProfile]-[Error]-delete : weightProfile is empty");
		return null;
	}

	@RequestMapping(value = "/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody WeightProfile save(@RequestBody String json){
		log.info("[WeightProfile]-[save]-User Request(JSON) : "+ json);
		WeightProfile weightProfile = new WeightProfile();
		try{
			Gson gson = GsonUtil.getGson();
			weightProfile = gson.fromJson(json, WeightProfile.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[WeightProfile]-[save]-User Request(GSON) : "+ weightProfile);
		if(weightProfile != null && ObjectUtil.isNotNullEmpty(weightProfile.getPartyId())&& ObjectUtil.isNotNullEmpty(weightProfile.getWeightUnit())){
			WeightProfile result = weightProfileService.save(weightProfile);
			log.info("[WeightProfile]-[Response]-save :" + result);
			return result;
		}
		
		log.warn("[WeightProfile]-[Error]-save : WeightProfile is empty");
		return null;
	}

	
}
