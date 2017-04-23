package com.jamie.rms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "weight_profile")
public class WeightProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileId;
	
	@Column(name = "partyId")
    private String partyId;
	
	@Column(name = "weightUnit")
    private String weightUnit;

	@Column(name = "createDate")
    private Date createDate;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "WeightProfile [profileId=" + profileId + ", partyId=" + partyId + ", weightUnit=" + weightUnit
				+ ", createDate=" + createDate + "]";
	}

	
	
	
}
