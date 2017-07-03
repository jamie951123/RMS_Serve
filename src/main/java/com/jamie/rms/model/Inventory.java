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
/**
 * @author jamie
 *
 */
@Entity(name = "v_inventory")
@Table(name ="v_inventory")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "productId",nullable = false, updatable=false)
	private Long productId;
	
	@Column(name = "party_id", updatable = false)
	private String partyId;
	
	@Column(name = "status", updatable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "weightId", updatable = false)
    private Long weightId;
	
	@Column(name = "quantityId", updatable = false)
    private Long quantityId;
	
	@Column(name = "productCode", updatable = false)
    private String productCode;
	
	@Column(name = "productName", updatable = false)
    private String productName;
	
	@Column(name = "totalGrossWeight", updatable = false)
    private BigDecimal totalGrossWeight;
	
	@Column(name = "weightUnit", updatable = false)
    private String weightUnit;
	
	@Column(name = "totalQty", updatable = false)
    private Integer totalQty;
	
	@Column(name = "quantityUnit", updatable = false)
    private String quantityUnit;

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

	public BigDecimal getTotalGrossWeight() {
		return totalGrossWeight;
	}

	public void setTotalGrossWeight(BigDecimal totalGrossWeight) {
		this.totalGrossWeight = totalGrossWeight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
