package com.jamie.rms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "weight_profile")
public class WeightProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "weightId",nullable = false, updatable=false)
	private Long weightId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "weightUnit")
    private String weightUnit;

	@Column(name = "createDate",nullable = false, updatable=false)
    private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;

	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status status;
		 
	
	@OneToMany(targetEntity=Product.class,
			mappedBy = "weightprofile", 
			fetch = FetchType.LAZY, 
			cascade= {CascadeType.ALL},
			orphanRemoval = false)
	@JsonBackReference
	@ForeignKey(name = "weightprofile_product_fk")
	private List<Product> product;
	
	
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WeightProfile [weightId=" + weightId + ", partyId=" + partyId + ", weightUnit=" + weightUnit
				+ ", createDate=" + createDate + ", createBy=" + createBy + ", lastModifiedDate=" + lastModifiedDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", status=" + status + "]";
	}

	
	
	

	
	
	
	
}
