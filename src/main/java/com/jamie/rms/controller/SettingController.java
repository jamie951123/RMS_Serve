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
import com.jamie.rms.model.Setting;
import com.jamie.rms.service.SettingService;
import com.jamie.rms.util.GsonUtil;
import com.jamie.rms.util.ObjectUtil;

@Controller
@RequestMapping(value = "rms/setting")
public class SettingController {
	Logger log = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;
	
	//Find
		@RequestMapping(value ="/findAll")
		public @ResponseBody List<Setting> findAll(){
			List<Setting> settings = settingService.findAll();
			log.info("[Setting]-[findAll]-User Response() : "+ settings);
			return settings;
		}
		
//		Save
		@RequestMapping(value="/save",produces="application/json;charset=UTF-8" ,method = RequestMethod.POST) 
		public @ResponseBody Setting save (@RequestBody String setting_json) {
			log.info("[Setting]-[save]-User Request(JSON) : "+ setting_json);
			Setting setting = new Setting();
			try{
				Gson gson  = GsonUtil.getGson();
				setting = gson.fromJson(setting_json, Setting.class);
			}catch (Exception e){
				e.printStackTrace();
				log.error("[Setting]-[save]-User Request(JSON-Format) :"+ "Wrong Format");
			}
			log.info("[Setting]-[save]-User Request(Model) :"+ setting);
			
			if(setting!=null && setting.getUserProfileId() != null){
				Setting response_Setting = settingService.save(setting);
				log.info("[Setting]-[save]-User Response(Model) :"+ response_Setting);
				return setting;
			}
			log.error("[Setting]-[save]-User Response(ERROR) :"+ "Setting Is Empty");
			return null;
			
		}
	
}
