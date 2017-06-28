package com.jamie.rms.model;


import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="Product")
@Table(name ="Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId",nullable = false, updatable=false)
	private Long productId;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "createDate",nullable = false, updatable=false)
	private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Column(name = "closeDate")
	private Date closeDate;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "productDescriptionEN")
	private String productDescriptionEN;
	
	@Column(name = "productDescriptionCH")
	private String productDescriptionCH;
	
	@Column(name = "weightId")
	private Long weightId;
	
	@Column(name = "quantityId")
	private Long quantityId;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.REFRESH,CascadeType.MERGE},optional=false)
	@ForeignKey(name = "product_weightprofile_fk")
	@JoinColumn(name="weightId", insertable=false, updatable =false)
	private WeightProfile weightprofile;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.REFRESH,CascadeType.MERGE},optional=false)
	@ForeignKey(name = "product_quantityProfile_fk")
	@JoinColumn(name="quantityId", insertable=false, updatable =false)
	private QuantityProfile quantityProfile;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProductDescriptionEN() {
		return productDescriptionEN;
	}

	public void setProductDescriptionEN(String productDescriptionEN) {
		this.productDescriptionEN = productDescriptionEN;
	}

	public String getProductDescriptionCH() {
		return productDescriptionCH;
	}

	public void setProductDescriptionCH(String productDescriptionCH) {
		this.productDescriptionCH = productDescriptionCH;
	}

	public Long getWeightId() {
		return weightId;
	}

	public void setWeightId(Long weightId) {
		this.weightId = weightId;
	}

	public Long getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Long quantityId) {
		this.quantityId = quantityId;
	}

	public WeightProfile getWeightprofile() {
		return weightprofile;
	}

	public void setWeightprofile(WeightProfile weightprofile) {
		this.weightprofile = weightprofile;
	}

	public QuantityProfile getQuantityProfile() {
		return quantityProfile;
	}

	public void setQuantityProfile(QuantityProfile quantityProfile) {
		this.quantityProfile = quantityProfile;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", partyId=" + partyId + ", status=" + status + ", createDate=" + createDate + ", createBy="
				+ createBy + ", closeDate=" + closeDate + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy="
				+ lastModifiedBy + ", remark=" + remark + ", productDescriptionEN=" + productDescriptionEN
				+ ", productDescriptionCH=" + productDescriptionCH + ", weightId=" + weightId + ", quantityId="
				+ quantityId + ", weightprofile=" + weightprofile + ", quantityProfile=" + quantityProfile + "]";
	}

	
	
	
	
}
