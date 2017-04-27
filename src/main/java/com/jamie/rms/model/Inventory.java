package com.jamie.rms.model;

import java.math.BigDecimal;
import java.util.Date;

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

import org.hibernate.annotations.Filter;

/**
 * @author jamie
 *
 */
@Entity(name = "inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventoryId")
	private Long inventoryId;
	
	@Column(name = "partyId")
	private String partyId;
	
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "createDate" )
	private Date createDate;
	
	@Column(name = "closeDate")
	private Date closeDate;
	
	@Column(name = "stockOutDate")
	private Date stockOutDate;
	
	@Column(name = "stockInDate")
	private Date stockInDate;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "grossWeight")
    private BigDecimal GrossWeight;
	
	@Column(name = "grossWeightUnit")
    private String GrossWeightUnit;
	
	@Column(name = "qty")
    private Integer itemQty;
	
	@Column(name = "qtyUnit")
    private String qtyUnit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId", insertable=false, updatable =false)
	@Filter(name="status",condition="status = :PROGRESS' ") 
	private Product Product;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Date getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}

	public Date getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getGrossWeight() {
		return GrossWeight;
	}

	public void setGrossWeight(BigDecimal grossWeight) {
		GrossWeight = grossWeight;
	}

	public String getGrossWeightUnit() {
		return GrossWeightUnit;
	}

	public void setGrossWeightUnit(String grossWeightUnit) {
		GrossWeightUnit = grossWeightUnit;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public String getQtyUnit() {
		return qtyUnit;
	}

	public void setQtyUnit(String qtyUnit) {
		this.qtyUnit = qtyUnit;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", partyId=" + partyId + ", productId=" + productId
				+ ", createDate=" + createDate + ", closeDate=" + closeDate + ", stockOutDate=" + stockOutDate
				+ ", stockInDate=" + stockInDate + ", status=" + status + ", GrossWeight=" + GrossWeight
				+ ", GrossWeightUnit=" + GrossWeightUnit + ", itemQty=" + itemQty + ", qtyUnit=" + qtyUnit
				+ ", Product=" + Product + "]";
	}

}
