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
import com.jamie.rms.model.Facebook;
import com.jamie.rms.model.UserProfile;
import com.jamie.rms.searchcriteria.object.FacebookSearchObject;
import com.jamie.rms.searchcriteria.object.UserProfileSearchObject;
import com.jamie.rms.service.FacebookService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@RequestMapping(value="/rms/facebook")
@Controller
public class FacebookController {
	Logger log = LoggerFactory.getLogger(FacebookController.class);
	
	@Autowired
	private FacebookService facebookService;
	
	@RequestMapping(value="/findAll")
	public @ResponseBody List<Facebook> findAll(){
		List<Facebook> facebooks = facebookService.findAll();
		log.info("[Facebook]-User Response(findAll) : "+ facebooks);
		return facebooks;
	}
	
	@RequestMapping(value="/findByFacebookId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody Facebook findByFacebookId (@RequestBody String facebookSearchObject_json) {	
		log.info("[Facebook]-[findByFacebookId]-User Request(JSON) : "+ facebookSearchObject_json);
		FacebookSearchObject facebookSearchObject = new FacebookSearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			facebookSearchObject = gson.fromJson(facebookSearchObject_json, FacebookSearchObject.class);
		}catch (Exception e){
			e.printStackTrace();
			log.error("[Facebook]-[findByFacebookId]-User Request(JSON-Format) :"+ "Wrong Format");
		}
		log.info("[Facebook]-[findByFacebookId]-User Request(Model) :"+ facebookSearchObject);

		if(facebookSearchObject!=null && ObjectUtil.isNotNullEmpty(facebookSearchObject.getFacebookId())){
			Facebook facebook = facebookService.findByFacebookId(facebookSearchObject.getFacebookId());
			log.info("[Facebook]-[findByFacebookId]-User Response(Model) :"+ facebook);
			return facebook;
		}
		log.error("[Facebook]-[findByFacebookId]-User Response(ERROR) :"+ "UserProfileSearchObject Is Empty");
		return null;
	}
	
	@RequestMapping(value="/countFacebookId",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody Integer countFacebookId (@RequestBody String facebookSearchObject_json) {	
		log.info("[Facebook]-[countFacebookId]-User Request(JSON) : "+ facebookSearchObject_json);
		FacebookSearchObject facebookSearchObject = new FacebookSearchObject();
		try{
			Gson gson = GsonUtil.getGson();
			facebookSearchObject = gson.fromJson(facebookSearchObject_json, FacebookSearchObject.class);
		}catch (Exception e){
			e.printStackTrace();
			log.error("[Facebook]-[countFacebookId]-User Request(JSON-Format) :"+ "Wrong Format");
		}
		log.info("[Facebook]-[countFacebookId]-User Request(Model) :"+ facebookSearchObject);

		if(facebookSearchObject!=null && ObjectUtil.isNotNullEmpty(facebookSearchObject.getFacebookId())){
			int count = facebookService.countFacebookId(facebookSearchObject.getFacebookId());
			log.info("[Facebook]-[countFacebookId]-User Response(Model) :"+ count);
			return count;
		}
		log.error("[Facebook]-[countFacebookId]-User Response(ERROR) :"+ "UserProfileSearchObject Is Empty");
		return null;
	}
	
//	Save
	@RequestMapping(value="/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
	public @ResponseBody Facebook save (@RequestBody String facebook_json) {
		log.info("[Facebook]-[save]-User Request(JSON) : "+ facebook_json);
		Facebook facebook = new Facebook();
		try{
			Gson gson  = GsonUtil.getGson();
			facebook = gson.fromJson(facebook_json, Facebook.class);
		}catch (Exception e){
			e.printStackTrace();
			log.error("[Facebook]-[save]-User Request(JSON-Format) :"+ "Wrong Format");
		}
		log.info("[Facebook]-[save]-User Request(Model) :"+ facebook);
		
		if(facebook!=null && ObjectUtil.isNotNullEmpty(facebook.getFacebookId()) && facebook.getId() != null){
			Facebook response_facebook = facebookService.save(facebook);
			log.info("[Facebook]-[save]-User Response(Model) :"+ response_facebook);
			return facebook;
		}
		log.error("[Facebook]-[save]-User Response(ERROR) :"+ "facebook Is Empty");
		return null;
		
	}
	
}
