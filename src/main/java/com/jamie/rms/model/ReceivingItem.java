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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.ForeignKey;

@Entity(name = "ReceivingItem")
@Table(name ="ReceivingItem")
public class ReceivingItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "receivingID",nullable = false, updatable=false)
	private Long receivingID;
	
	@Column(name = "productId")
    private Long productId;
	
	@Column(name = "itemStatus",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status itemStatus;
	
	@Column(name = "orderId")
    private Long orderId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "itemCreateDate",nullable = false, updatable=false)
    private Date itemCreateDate;
	
	@Column(name = "itemCreateBy",nullable = false, updatable=false)
	private String itemCreateBy;
	
	@Column(name = "itemReceivingDate",nullable = false)
    private Date itemReceivingDate;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date itemLastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String itemLastModifiedBy;
	
	@Column(name = "itemGrossWeight")
    private BigDecimal itemGrossWeight;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
	@Column(name = "itemRemark")
    private String itemRemark;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId", insertable=false, updatable =false)
	@ForeignKey(name = "product_fk")
	@Filter(name="status",condition="status = :PROGRESS' ") 
	private Product product;

	public Inventory getInventory(){
		Inventory inv = new Inventory();
		inv.setCreateDate(this.getItemCreateDate());
		inv.setCreateBy(this.getItemCreateBy());
		inv.setPartyId(this.getPartyId());
		inv.setStatus(this.getItemStatus());
		
		inv.setProductId(this.getProductId());
		inv.setProduct(this.getProduct());
		inv.setCreateDate(this.getItemCreateDate());
		inv.setStockInDate(this.getItemReceivingDate());
		inv.setGrossWeight(this.getItemGrossWeight());
		inv.setQty(this.getItemQty());
		return inv;
		
	}

	public Long getReceivingID() {
		return receivingID;
	}

	public void setReceivingID(Long receivingID) {
		this.receivingID = receivingID;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Status getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Status itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public Date getItemCreateDate() {
		return itemCreateDate;
	}

	public void setItemCreateDate(Date itemCreateDate) {
		this.itemCreateDate = itemCreateDate;
	}

	public String getItemCreateBy() {
		return itemCreateBy;
	}

	public void setItemCreateBy(String itemCreateBy) {
		this.itemCreateBy = itemCreateBy;
	}

	public Date getItemReceivingDate() {
		return itemReceivingDate;
	}

	public void setItemReceivingDate(Date itemReceivingDate) {
		this.itemReceivingDate = itemReceivingDate;
	}

	

	public Date getItemLastModifiedDate() {
		return itemLastModifiedDate;
	}

	public void setItemLastModifiedDate(Date itemLastModifiedDate) {
		this.itemLastModifiedDate = itemLastModifiedDate;
	}

	public String getItemLastModifiedBy() {
		return itemLastModifiedBy;
	}

	public void setItemLastModifiedBy(String itemLastModifiedBy) {
		this.itemLastModifiedBy = itemLastModifiedBy;
	}

	public BigDecimal getItemGrossWeight() {
		return itemGrossWeight;
	}

	public void setItemGrossWeight(BigDecimal itemGrossWeight) {
		this.itemGrossWeight = itemGrossWeight;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public String getItemRemark() {
		return itemRemark;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ReceivingItem [receivingID=" + receivingID + ", productId=" + productId + ", itemStatus=" + itemStatus
				+ ", orderId=" + orderId + ", partyId=" + partyId + ", itemCreateDate=" + itemCreateDate
				+ ", itemCreateBy=" + itemCreateBy + ", itemReceivingDate=" + itemReceivingDate
				+ ", itemLastModifiedDate=" + itemLastModifiedDate + ", itemLastModifiedBy=" + itemLastModifiedBy
				+ ", itemGrossWeight=" + itemGrossWeight + ", itemQty=" + itemQty + ", itemRemark=" + itemRemark
				+ ", product=" + product + ", getInventory()=" + getInventory() + ", getReceivingID()="
				+ getReceivingID() + ", getProductId()=" + getProductId() + ", getItemStatus()=" + getItemStatus()
				+ ", getOrderId()=" + getOrderId() + ", getPartyId()=" + getPartyId() + ", getItemCreateDate()="
				+ getItemCreateDate() + ", getItemCreateBy()=" + getItemCreateBy() + ", getItemReceivingDate()="
				+ getItemReceivingDate() + ", getItemLastModifiedDate()=" + getItemLastModifiedDate()
				+ ", getItemLastModifiedBy()=" + getItemLastModifiedBy() + ", getItemGrossWeight()="
				+ getItemGrossWeight() + ", getItemQty()=" + getItemQty() + ", getItemRemark()=" + getItemRemark()
				+ ", getProduct()=" + getProduct() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
	
}
