package com.jamie.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.rms.dao.SettingDao;
import com.jamie.rms.model.Setting;

@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	private SettingDao settingDao;
	
	@Override
	public List<Setting> findAll() {
		// TODO Auto-generated method stub
		return settingDao.findAll();
	}

	@Override
	public Setting save(Setting setting) {
		// TODO Auto-generated method stub
		return settingDao.save(setting);
	}

}
