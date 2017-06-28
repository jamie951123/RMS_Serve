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
import com.jamie.rms.model.QuantityProfile;
import com.jamie.rms.model.ResponseMessage;
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
	
	@Autowired 
	private ProductController productController;
	
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
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/delete",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody ResponseMessage delete(@RequestBody String quantityProfile_json){
		log.info("[QuantityProfile]-[delete]-User Request(JSON) : "+ quantityProfile_json);
		QuantityProfile quantityProfile = new QuantityProfile();
		try{
			Gson gson = GsonUtil.getGson();
			quantityProfile = gson.fromJson(quantityProfile_json, QuantityProfile.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[QuantityProfile]-[delete]-User Request(GSON) : "+ quantityProfile);
//		//remove (FK) Product
//		try{
//			productController.updateQuantityIdNullByQuantityIdAndPartyId(quantityProfile_json);
//		}catch (Exception e){
//			e.printStackTrace();
//			log.warn("[QuantityProfile]-[Error]-delete : QuantityProfile is empty");
//			throw e;
//		}
		//hibernate remove (FK) OnetoMany Product
		//remove (FK) QuantityProfile
		try{
			ResponseMessage responseMessage = quantityProfileService.delete(quantityProfile);
			log.info("[QuantityProfile]-[ResponseMessage]-[Response]-delete :" + responseMessage);
			return responseMessage;
		}catch (Exception e){
			e.printStackTrace();
			log.warn("[QuantityProfile]-[Error]-delete : QuantityProfile is empty");
			throw e;
		}

	}
	
	@RequestMapping(value = "/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody QuantityProfile save (@RequestBody String json){
		log.info("[QuantityProfile]-[save]-User Request(JSON) : "+ json);
		QuantityProfile quantityProfile = new QuantityProfile();
		try{
			Gson gson = GsonUtil.getGson();
			quantityProfile = gson.fromJson(json, QuantityProfile.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[QuantityProfile]-[save]-User Request(GSON) : "+ quantityProfile);
		if(quantityProfile != null ){
			QuantityProfile result = quantityProfileService.save(quantityProfile);
			log.info("[QuantityProfile]-[Response]-save :" + result);
			return result;
		}
		
		log.warn("[QuantityProfile]-[Error]-save : QuantityProfile is empty");
		return null;
	}
	
	@RequestMapping(value = "/updateQtyByQuantityIdAndPartyIdAndQtyUnit",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST)
	public @ResponseBody Integer updateQtyByQuantityIdAndPartyIdAndQtyUnit (@RequestBody String json){
		log.info("[QuantityProfile]-[updateQtyByQuantityIdAndPartyIdAndQtyUnit]-User Request(JSON) : "+ json);
		QuantityProfile quantityProfile = new QuantityProfile();
		try{
			Gson gson = GsonUtil.getGson();
			quantityProfile = gson.fromJson(json, QuantityProfile.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		log.info("[QuantityProfile]-[updateQtyByQuantityIdAndPartyIdAndQtyUnit]-User Request(GSON) : "+ quantityProfile);
	
		if(quantityProfile != null){
			Integer result = quantityProfileService.updateQtyByQuantityIdAndPartyIdAndQtyUnit(quantityProfile);
			log.info("[QuantityProfile]-[Response]-updateQtyByQuantityIdAndPartyIdAndQtyUnit :" + result);
			return result;
		}
		
		
		log.warn("[QuantityProfile]-[Error]-updateQtyByQuantityIdAndPartyIdAndQtyUnit : QuantityProfile is empty");
		return null;
	}
	
}
