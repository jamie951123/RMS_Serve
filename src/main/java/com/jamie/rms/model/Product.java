package com.jamie.rms.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "partyId")
    private String partyId;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "createDate" )
	private Date createDate;
	
	@Column(name = "closeDate")
	private Date closeDate;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "productDescriptionEN")
	private String productDescriptionEN;
	
	@Column(name = "productDescriptionCH")
	private String productDescriptionCH;
	

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
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
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
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", partyId=" + partyId + ", status=" + status + ", createDate=" + createDate + ", closeDate="
				+ closeDate + ", remark=" + remark + ", productDescriptionEN=" + productDescriptionEN
				+ ", productDescriptionCH=" + productDescriptionCH + "]";
	}
	
	
	
}
