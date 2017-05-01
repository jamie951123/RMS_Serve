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
    private BigDecimal grossWeight;
	
	@Column(name = "grossWeightUnit")
    private String grossWeightUnit;
	
	@Column(name = "qty")
    private Integer qty;
	
	@Column(name = "qtyUnit")
    private String qtyUnit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId", insertable=false, updatable =false)
	@Filter(name="status",condition="status = :PROGRESS' ") 
	private Product product;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", partyId=" + partyId + ", productId=" + productId
				+ ", createDate=" + createDate + ", closeDate=" + closeDate + ", stockOutDate=" + stockOutDate
				+ ", stockInDate=" + stockInDate + ", status=" + status + ", grossWeight=" + grossWeight
				+ ", grossWeightUnit=" + grossWeightUnit + ", qty=" + qty + ", qtyUnit=" + qtyUnit + ", product="
				+ product + "]";
	}

	
	
	

}