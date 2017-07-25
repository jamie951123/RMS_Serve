package com.jamie.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.jamie.rms.model.Setting;

@Service
public interface SettingDao extends JpaRepository<Setting,Long>{

}
