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
	
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "partyId")
	private String partyId;
		
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
	
	@Column(name = "qty")
    private Integer qty;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId", insertable=false, updatable =false)
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


	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", partyId=" + partyId
				+ ", createDate=" + createDate + ", closeDate=" + closeDate + ", stockOutDate=" + stockOutDate
				+ ", stockInDate=" + stockInDate + ", status=" + status + ", grossWeight=" + grossWeight + ", qty="
				+ qty + ", product=" + product + "]";
	}

	


	
	
	

	
	
	

}
