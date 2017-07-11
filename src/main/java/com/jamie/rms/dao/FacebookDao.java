package com.jamie.rms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.rms.model.Facebook;

@Repository
@Transactional
public interface FacebookDao extends JpaRepository<Facebook,Long> {

	//Find
	Facebook findByFacebookId(String facebookId);
	
	@Query("select count(*) from Facebook where facebookId = ?1")
	int countFacebookId(String facebookId);

}
