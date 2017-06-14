package com.jamie.rms.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jamie
 *
 */
@Entity(name = "user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userProfileId",nullable = false, updatable=false)
	private Long userProfileId;
	
	@Column(name = "username",nullable = false)
	private String username;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "partyId",nullable = false)
	private String partyId;
	
	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate",nullable = false, updatable=false)
	private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "closeDate")
	private Date closeDate;

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", username=" + username + ", password=" + password
				+ ", partyId=" + partyId + ", status=" + status + ", createDate=" + createDate + ", createBy="
				+ createBy + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", closeDate=" + closeDate + "]";
	}

	
	
	
	
	
}
