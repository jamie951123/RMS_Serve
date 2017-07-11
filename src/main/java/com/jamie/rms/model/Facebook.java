package com.jamie.rms.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Facebook")
@Table(name= "Facebook")
public class Facebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "userProfileId",unique = true)
	private Long userProfileId;
	
	@Column(name = "facebookId",unique = true)
	private String facebookId;
	
	@OneToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REMOVE,CascadeType.REFRESH},
			optional = true, orphanRemoval = true
			)
	@JsonBackReference
	@JoinColumn(name = "userProfileId", referencedColumnName="userProfileId", insertable=false, updatable =false)
	private UserProfile userProfile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	

	

	

	
	
	
	
}
