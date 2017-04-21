package com.jamie.rms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userProfileId")
	private Long userProfileId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "partyId")
	private String partyId;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "createDate")
	private Date createDate;
	
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

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", username=" + username + ", password=" + password
				+ ", partyId=" + partyId + ", status=" + status + ", createDate=" + createDate + ", closeDate="
				+ closeDate + "]";
	}
	
	
	
}
