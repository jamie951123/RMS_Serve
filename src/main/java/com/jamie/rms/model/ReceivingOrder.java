package com.jamie.rms.model;


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

@Entity(name="receiving_order")
public class ReceivingOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name = "partyId")
    private String partyId;
	
	@Column(name = "remark")
    private String remark;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
    private Status status;
	
	@Column(name = "receivingDate")
    private Date receivingDate;
	
	@Column(name = "createDate")
    private Date createDate;
	
	@Column(name = "closeDate")
    private Date closeDate;
	
	@Column(name = "actualQty")
    private Integer actualQty;
	
	@Column(name = "estimateQty")
    private Integer estimateQty;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
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
	public Date getReceivingDate() {
		return receivingDate;
	}
	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
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
	@Override
	public String toString() {
		return "ReceivingOrder [orderId=" + orderId + ", partyId=" + partyId + ", receivingDate=" + receivingDate
				+ ", remark=" + remark + ", status=" + status + ", createDate=" + createDate + ", closeDate="
				+ closeDate + ", actualQty=" + actualQty + ", estimateQty=" + estimateQty + ", itemQty=" + itemQty
				+ "]";
	}
    
	
}
