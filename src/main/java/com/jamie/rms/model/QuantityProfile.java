package com.jamie.rms.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

/**
 * @author jamie
 *
 */
/**
 * @author jamie
 *
 */
/**
 * @author Jamie
 *
 */
@Entity(name = "QuantityProfile")
@Table(name ="QuantityProfile")
public class QuantityProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quantityId",nullable = false, updatable=false)
	private Long quantityId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "quantityUnit")
    private String quantityUnit;

	@Column(name = "createDate",nullable = false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
	
	@Column(name = "createBy",nullable = false)
	private String createBy;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;

	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status status;
	
	@OneToMany(mappedBy = "quantityProfile", 
			fetch = FetchType.EAGER, 
			cascade= {CascadeType.REMOVE,CascadeType.REFRESH},
			orphanRemoval = true)
	@ForeignKey(name = "quantityProfile_product_fk")
	private List<Product> product;
	
	public Long getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Long quantityId) {
		this.quantityId = quantityId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
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
		return "QuantityProfile [quantityId=" + quantityId + ", partyId=" + partyId + ", quantityUnit=" + quantityUnit
				+ ", createDate=" + createDate + ", createBy=" + createBy + ", lastModifiedDate=" + lastModifiedDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", status=" + status + "]";
	}

	

	
	
	

	

	

	
	
	
	
	
}
