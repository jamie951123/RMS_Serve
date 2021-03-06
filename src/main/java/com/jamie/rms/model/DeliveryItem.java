package com.jamie.rms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="DeliveryItem")
@Table(name="DeliveryItem")
public class DeliveryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deliveryItemId",nullable = false, updatable=false)
	private Long deliveryItemId;
	
	@Column(name = "itemStatus",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status itemStatus;
	
	@Column(name = "orderId",nullable = false)
    private Long orderId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "itemStockOutDate",nullable = false)
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
	
	@Column(name = "receivingId")
    private Long receivingId;

	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REFRESH},
			optional=true
			)
	@JoinColumn(name="orderId", insertable=false, updatable =false,nullable=true)
	@ForeignKey(name = "deliveryItem_deliveryOrder_fk")
	@JsonBackReference
	private DeliveryOrder deliveryOrder;
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REFRESH},
			optional=true
			)
	@JoinColumn(name="receivingId",referencedColumnName = "receivingId", insertable=false, updatable =false,nullable=true)
	@ForeignKey(name = "deliveryItem_receivingItem_fk")
	 @JsonManagedReference
	private ReceivingItem receivingItem;

//	@OneToOne(fetch = FetchType.LAZY,
//			mappedBy = "deliveryItem",
//			cascade= {CascadeType.REFRESH,CascadeType.REMOVE},
//			orphanRemoval = true
//			)
//	@ForeignKey(name = "deliveryItem_inventory_fk")
//	@JsonBackReference
//	private Inventory inventory;
	
	
//	public Inventory newInventory(){
//		Inventory inv = new Inventory();
//		inv.setCreateDate(this.getItemCreateDate());
//		inv.setCreateBy(this.getItemCreateBy());
//		inv.setPartyId(this.getPartyId());
//		inv.setStatus(this.getItemStatus());
//		inv.setCreateDate(this.getItemCreateDate());
//		inv.setOperationType(OperationType.OUT);
////		inv.setStockOutDate(this.getItemStockOutDate());
////		inv.setGrossWeight(this.getItemGrossWeight());
////		inv.setQty(this.getItemQty());
//		inv.setDeliveryItemId(deliveryItemId);
//		return inv;
//		
//	}
	
	public Long getDeliveryItemId() {
		return deliveryItemId;
	}




	public void setDeliveryItemId(Long deliveryItemId) {
		this.deliveryItemId = deliveryItemId;
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




	public Long getReceivingId() {
		return receivingId;
	}




	public void setReceivingId(Long receivingId) {
		this.receivingId = receivingId;
	}




	public DeliveryOrder getDeliveryOrder() {
		return deliveryOrder;
	}




	public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
		this.deliveryOrder = deliveryOrder;
	}




	public ReceivingItem getReceivingItem() {
		return receivingItem;
	}




	public void setReceivingItem(ReceivingItem receivingItem) {
		this.receivingItem = receivingItem;
	}




	@Override
	public String toString() {
		return "DeliveryItem [deliveryItemId=" + deliveryItemId + ", itemStatus=" + itemStatus + ", orderId=" + orderId
				+ ", partyId=" + partyId + ", itemStockOutDate=" + itemStockOutDate + ", itemCreateDate="
				+ itemCreateDate + ", itemCreateBy=" + itemCreateBy + ", itemLastModifiedDate=" + itemLastModifiedDate
				+ ", itemLastModifiedBy=" + itemLastModifiedBy + ", itemCloseDate=" + itemCloseDate + ", itemRemark="
				+ itemRemark + ", itemGrossWeight=" + itemGrossWeight + ", itemQty=" + itemQty + ", receivingId="
				+ receivingId + ", receivingItem=" + receivingItem + "]";
	}

	
	

	
	
	
	
}