package com.jamie.rms.model;

import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "ReceivingItem")
@Table(name ="ReceivingItem")
public class ReceivingItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "receivingId",nullable = false, updatable=false)
	private Long receivingId;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REFRESH})
	@JoinColumn(name="productId", insertable=false, updatable =false)
	@ForeignKey(name = "receivingItem_product_fk")
	private Product product;

	@OneToMany(mappedBy = "receivingItem",
			fetch = FetchType.LAZY,
					cascade= {CascadeType.REFRESH,CascadeType.REMOVE},
//			orphanRemoval = false
					orphanRemoval = true
			)
	List<DeliveryItem> deliveryItem;
	 
	@ManyToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.REFRESH},
			optional=true)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable=false, updatable =false, nullable=true)
	@JsonBackReference
	private ReceivingOrder receivingOrder;
	
	
//	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.ALL},optional=false)
//	@JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable=false, updatable =false)
//	@JsonBackReference
//	private ReceivingOrder receivingOrder;
//	
//	@ManyToOne(cascade= {CascadeType.ALL},fetch = FetchType.EAGER)
//	@JoinColumn(name="orderId",referencedColumnName="orderId", insertable=false, updatable =false)
////	@ForeignKey(name = "receivingItem_receivingOrder_fk")
////	@JsonIgnore
//	 @JsonManagedReference
//	private ReceivingOrder receivingOrder = new ReceivingOrder();
//	
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


	
//	public ReceivingOrder getReceivingOrder() {
//		return receivingOrder;
//	}
//
//
//
//	public void setReceivingOrder(ReceivingOrder receivingOrder) {
//		this.receivingOrder = receivingOrder;
//	}
//


	public Long getReceivingId() {
		return receivingId;
	}


	public void setReceivingId(Long receivingId) {
		this.receivingId = receivingId;
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
		return "ReceivingItem [receivingId=" + receivingId + ", productId=" + productId + ", itemStatus=" + itemStatus
				+ ", orderId=" + orderId + ", partyId=" + partyId + ", itemCreateDate=" + itemCreateDate
				+ ", itemCreateBy=" + itemCreateBy + ", itemReceivingDate=" + itemReceivingDate
				+ ", itemLastModifiedDate=" + itemLastModifiedDate + ", itemLastModifiedBy=" + itemLastModifiedBy
				+ ", itemGrossWeight=" + itemGrossWeight + ", itemQty=" + itemQty + ", itemRemark=" + itemRemark
				+ ", product=" + product + "]";
	}

	
	

	
	
}
