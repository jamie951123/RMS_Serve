package com.jamie.rms.service;

import java.util.List;

import com.jamie.rms.model.Setting;

public interface SettingService {
	
	//FindAll
	List<Setting>findAll();

	//Save 
	Setting save(Setting setting);
}
