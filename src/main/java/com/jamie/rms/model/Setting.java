package com.jamie.rms.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="Setting")
@Table(name="Setting")
public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "userProfileId",unique = true)
	private Long userProfileId;
	
	@Column(name = "dateRange")
	private Integer dateRange;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	
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

	public Integer getDateRange() {
		return dateRange;
	}

	public void setDateRange(Integer dateRange) {
		this.dateRange = dateRange;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	
	
	
	
}
