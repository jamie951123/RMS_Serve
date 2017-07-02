package com.jamie.rms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jamie
 *
 */
/**
 * @author jamie
 *
 */
@Entity(name = "Inventory")
@Table(name ="Inventory")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventoryId",nullable = false, updatable=false)
	private Long inventoryId;
	
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "partyId",nullable = false)
	private String partyId;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate",nullable = false, updatable=false)
	private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "closeDate")
	private Date closeDate;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;
	
	@Column(name = "stockOutDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stockOutDate;
	
	@Column(name = "stockInDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stockInDate;
	
	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "grossWeight")
    private BigDecimal grossWeight;
	
	@Column(name = "qty")
    private Integer qty;
	
	@Column(name = "receivingId",nullable = false, updatable=false)
	private Long receivingId;
	
//	@OneToOne(fetch = FetchType.EAGER,
//			cascade= {CascadeType.REMOVE,CascadeType.REFRESH},
//			optional=true
//			)
//	@JoinColumn(name="receivingId", insertable=false, updatable =false)
//	private ReceivingItem receivingItem;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
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

	

}
