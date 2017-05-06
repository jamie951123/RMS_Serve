package com.jamie.rms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jamie
 *
 */
@Entity
@Table(name = "v_inventory_sum")
public class InventorySum implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", updatable = false)
	private String id;
	
	@Column(name = "productId", updatable = false)
	private Long productId;
	
	@Column(name = "weightId", updatable = false)
    private Long weightId;
	
	@Column(name = "quantityId", updatable = false)
    private Long quantityId;
	
	
	@Column(name = "partyId", updatable = false)
	private String partyId;
	
	@Column(name = "status", updatable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "grossWeight", updatable = false)
    private BigDecimal grossWeight;
	
	@Column(name = "weightUnit", updatable = false)
    private String weightUnit;
	
	@Column(name = "qty", updatable = false)
    private Integer qty;
	
	@Column(name = "quantityUnit", updatable = false)
    private String quantityUnit;
	
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

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InventorySum [id=" + id + ", productId=" + productId + ", weightId=" + weightId + ", quantityId="
				+ quantityId + ", partyId=" + partyId + ", status=" + status + ", grossWeight=" + grossWeight
				+ ", weightUnit=" + weightUnit + ", qty=" + qty + ", quantityUnit=" + quantityUnit + ", productCode="
				+ productCode + ", productName=" + productName + "]";
	}
	
	
	
	
	
}
