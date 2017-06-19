package com.jamie.rms.model;


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

import org.hibernate.annotations.ForeignKey;

@Entity(name = "ReceivingOrder")
@Table(name ="ReceivingOrder")
public class ReceivingOrder {

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
	
	@Column(name = "receivingDate",nullable = false)
    private Date receivingDate;
	
	@Column(name = "createDate",nullable = false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
	
	@Column(name = "createBy",nullable = false, updatable=false)
	private String createBy;
	
	@Column(name = "closeDate")
	@Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;
	
	@Column(name = "lastModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Column(name = "lastModifiedBy")
	private String lastModifiedBy;
	
	@Column(name = "actualQty")
    private Integer actualQty;
	
	@Column(name = "estimateQty")
    private Integer estimateQty;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
	@OneToMany(cascade= {CascadeType.ALL},fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name="orderId", insertable=false, updatable =false)
	@ForeignKey(name = "ReceivingOrder_fk")
	private List<ReceivingItem> receivingItem;

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

	public Date getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
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

	public Integer getActualQty() {
		return actualQty;
	}

	public void setActualQty(Integer actualQty) {
		this.actualQty = actualQty;
	}

	public Integer getEstimateQty() {
		return estimateQty;
	}

	public void setEstimateQty(Integer estimateQty) {
		this.estimateQty = estimateQty;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public List<ReceivingItem> getReceivingItem() {
		return receivingItem;
	}

	public void setReceivingItem(List<ReceivingItem> receivingItem) {
		this.receivingItem = receivingItem;
	}

	@Override
	public String toString() {
		return "ReceivingOrder [orderId=" + orderId + ", partyId=" + partyId + ", remark=" + remark + ", status="
				+ status + ", receivingDate=" + receivingDate + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", closeDate=" + closeDate + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy="
				+ lastModifiedBy + ", actualQty=" + actualQty + ", estimateQty=" + estimateQty + ", itemQty=" + itemQty
				+ ", receivingItem=" + receivingItem + "]";
	}
	
	
	
	
}
