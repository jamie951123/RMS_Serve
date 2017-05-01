package com.jamie.rms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_inventory_sum")
public class InventorySum implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", updatable = false)
	private String id;
	
	@Column(name = "productId", updatable = false)
	private Long productId;
	
	@Column(name = "partyId", updatable = false)
	private String partyId;
	
	@Column(name = "status", updatable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "grossWeight", updatable = false)
    private BigDecimal grossWeight;
	
	@Column(name = "grossWeightUnit", updatable = false)
    private String grossWeightUnit;
	
	@Column(name = "qty", updatable = false)
    private Integer qty;
	
	@Column(name = "qtyUnit", updatable = false)
    private String qtyUnit;
	
	@Column(name = "productCode", updatable = false)
    private String productCode;
	
	@Column(name = "productName", updatable = false)
    private String productName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public BigDecimal getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(BigDecimal grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getGrossWeightUnit() {
		return grossWeightUnit;
	}

	public void setGrossWeightUnit(String grossWeightUnit) {
		this.grossWeightUnit = grossWeightUnit;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getQtyUnit() {
		return qtyUnit;
	}

	public void setQtyUnit(String qtyUnit) {
		this.qtyUnit = qtyUnit;
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

	@Override
	public String toString() {
		return "InventorySum [id=" + id + ", productId=" + productId + ", partyId=" + partyId + ", status=" + status
				+ ", grossWeight=" + grossWeight + ", grossWeightUnit=" + grossWeightUnit + ", qty=" + qty
				+ ", qtyUnit=" + qtyUnit + ", productCode=" + productCode + ", productName=" + productName + "]";
	}
	
	
	
}
