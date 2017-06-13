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

import org.hibernate.annotations.ForeignKey;


@Entity(name="DeliveryOrder")
@Table(name="DeliveryOrder")
public class DeliveryOrder {

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
	
	@Column(name = "stockOutDate")
	private Date stockOutDate;
	
	@Column(name = "createDate")
    private Date createDate;
	
	@Column(name = "createBy")
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

	@OneToMany(cascade= {CascadeType.ALL},fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name="orderId", insertable=false, updatable =false)
	@ForeignKey(name = "DeliveryOrder_fk")
	private List<DeliveryItem> deliveryItem = new ArrayList<DeliveryItem>();
	
	
	public List<DeliveryItem> getDeliveryItem() {
		return deliveryItem;
	}

	public void setDeliveryItem(List<DeliveryItem> deliveryItem) {
		this.deliveryItem = deliveryItem;
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

	@Override
	public String toString() {
		return "DeliveryOrder [orderId=" + orderId + ", partyId=" + partyId + ", remark=" + remark + ", status="
				+ status + ", stockOutDate=" + stockOutDate + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", closeDate=" + closeDate + ", itemQty=" + itemQty + ", doNo=" + doNo + ", lastModifiedDate="
				+ lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", deliveryItem=" + deliveryItem + "]";
	}
	
	
	
}