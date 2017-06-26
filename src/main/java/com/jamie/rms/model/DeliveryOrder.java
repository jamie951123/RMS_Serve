package com.jamie.rms.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="DeliveryOrder")
@Table(name="DeliveryOrder")
public class DeliveryOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId",nullable = false, updatable=false)
	private Long orderId;
	
	@Column(name = "partyId",nullable = false)
    private String partyId;
	
	@Column(name = "remark")
    private String remark;
	
	@Column(name = "status",nullable = false)
	@Enumerated(EnumType.STRING)
    private Status status;
	
	@Column(name = "stockOutDate",nullable = false)
	private Date stockOutDate;
	
	@Column(name = "createDate",nullable = false, updatable=false)
    private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Column(name = "closeDate")
    private Date closeDate;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
	@Column(name = "doNo")
	private String doNo;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;

	@Fetch(FetchMode.SELECT)
	@OneToMany(targetEntity=DeliveryItem.class , cascade = { CascadeType.ALL},mappedBy = "deliveryItemId",fetch = FetchType.LAZY)
	@JsonManagedReference 
	@ForeignKey(name = "deliveryOrder_deliveryItem_fk")
	private List<DeliveryItem> deliveryItem;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
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

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public String getDoNo() {
		return doNo;
	}

	public void setDoNo(String doNo) {
		this.doNo = doNo;
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

	public List<DeliveryItem> getDeliveryItem() {
		return deliveryItem;
	}

	public void setDeliveryItem(List<DeliveryItem> deliveryItem) {
		this.deliveryItem = deliveryItem;
	}

	@Override
	public String toString() {
		return "DeliveryOrder [orderId=" + orderId + ", partyId=" + partyId + ", remark=" + remark + ", status="
				+ status + ", stockOutDate=" + stockOutDate + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", closeDate=" + closeDate + ", itemQty=" + itemQty + ", doNo=" + doNo + ", lastModifiedDate="
				+ lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", deliveryItem=" + deliveryItem + "]";
	}
	
	
	
	
	
}
