package com.jamie.rms.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "weight_profile")
public class WeightProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long weightId;
	
	@Column(name = "partyId")
    private String partyId;
	
	@Column(name = "weightUnit")
    private String weightUnit;

	@Column(name = "createDate")
	@Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

//	@OneToMany(cascade= {CascadeType.ALL},fetch = FetchType.EAGER,orphanRemoval = true)
//	@JoinColumn(name="productId", insertable=false, updatable =false)
//	private Set<Product> product;
	
	
	public Long getWeightId() {
		return weightId;
	}

	public void setWeightId(Long weightId) {
		this.weightId = weightId;
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
		return "WeightProfile [weightId=" + weightId + ", partyId=" + partyId + ", weightUnit=" + weightUnit
				+ ", createDate=" + createDate + "]";
	}

	
	
	
	
}
