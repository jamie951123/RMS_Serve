package com.jamie.rms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;


@Entity(name="DeliveryItem")
@Table(name="DeliveryItem")
public class DeliveryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deliveryItemId",nullable = false, updatable=false)
	private Long deliveryItemId;
	
	@Column(name = "productId")
    private Long productId;
	
	@Column(name = "itemStatus",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status itemStatus;
	
	@Column(name = "orderId")
    private Long orderId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "itemStockOutDate")
	private Date itemStockOutDate;
	
	@Column(name = "itemCreateDate",nullable = false, updatable=false)
    private Date itemCreateDate;
	
	@Column(name = "itemCreateBy",nullable = false, updatable=false)
	private String itemCreateBy;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date itemLastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String itemLastModifiedBy;
	
	@Column(name = "itemCloseDate")
    private Date itemCloseDate;
	
	@Column(name = "itemRemark")
    private String itemRemark;
	
	@Column(name = "itemGrossWeight")
    private BigDecimal itemGrossWeight;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
	@Column(name = "receivingID",nullable=false)
    private Long receivingID;

	@ManyToOne(cascade= {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="receivingID", insertable=false, updatable =false,nullable=true)
	@ForeignKey(name = "DeliveryItem_fk")
	private ReceivingItem receivingItem;
	
	public Long getDeliveryItemId() {
		return deliveryItemId;
	}

	public void setDeliveryItemId(Long deliveryItemId) {
		this.deliveryItemId = deliveryItemId;
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

	public Date getItemStockOutDate() {
		return itemStockOutDate;
	}

	public void setItemStockOutDate(Date itemStockOutDate) {
		this.itemStockOutDate = itemStockOutDate;
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

	public Date getItemCloseDate() {
		return itemCloseDate;
	}

	public void setItemCloseDate(Date itemCloseDate) {
		this.itemCloseDate = itemCloseDate;
	}

	public String getItemRemark() {
		return itemRemark;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
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

	
	public Long getReceivingID() {
		return receivingID;
	}

	public void setReceivingID(Long receivingID) {
		this.receivingID = receivingID;
	}

	public ReceivingItem getReceivingItem() {
		return receivingItem;
	}

	public void setReceivingItem(ReceivingItem receivingItem) {
		this.receivingItem = receivingItem;
	}

	@Override
	public String toString() {
		return "DeliveryItem [deliveryItemId=" + deliveryItemId + ", productId=" + productId + ", itemStatus="
				+ itemStatus + ", orderId=" + orderId + ", partyId=" + partyId + ", itemStockOutDate="
				+ itemStockOutDate + ", itemCreateDate=" + itemCreateDate + ", itemCreateBy=" + itemCreateBy
				+ ", itemLastModifiedDate=" + itemLastModifiedDate + ", itemLastModifiedBy=" + itemLastModifiedBy
				+ ", itemCloseDate=" + itemCloseDate + ", itemRemark=" + itemRemark + ", itemGrossWeight="
				+ itemGrossWeight + ", itemQty=" + itemQty + ", receivingID=" + receivingID + ", receivingItem="
				+ receivingItem + "]";
	}
	
	
	
	
}