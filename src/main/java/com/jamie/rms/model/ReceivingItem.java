package com.jamie.rms.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "receiving_item")
public class ReceivingItem {
	@Id
	@GeneratedValue()
	@Column(name = "receivingID")
	private Long receivingID;
	@Column(name = "productId")
    private Long productId;
	@Column(name = "itemStatus")
    private String itemStatus;
	@Column(name = "orderId")
    private Long orderId;
	@Column(name = "partyId")
    private String partyId;
	@Column(name = "itemCreateDate")
    private Date itemCreateDate;
	@Column(name = "itemReceivingDate")
    private Date itemReceivingDate;
	@Column(name = "itemGrossWeight")
    private BigDecimal itemGrossWeight;
	@Column(name = "itemGrossWeightUnit")
    private String itemGrossWeightUnit;
	@Column(name = "itemQty")
    private Integer itemQty;
	@Column(name = "itemQtyUnit")
    private String itemQtyUnit;
	@Column(name = "itemRemark")
    private String itemRemark;
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
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
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
	public Date getItemReceivingDate() {
		return itemReceivingDate;
	}
	public void setItemReceivingDate(Date itemReceivingDate) {
		this.itemReceivingDate = itemReceivingDate;
	}
	public BigDecimal getItemGrossWeight() {
		return itemGrossWeight;
	}
	public void setItemGrossWeight(BigDecimal itemGrossWeight) {
		this.itemGrossWeight = itemGrossWeight;
	}
	public String getItemGrossWeightUnit() {
		return itemGrossWeightUnit;
	}
	public void setItemGrossWeightUnit(String itemGrossWeightUnit) {
		this.itemGrossWeightUnit = itemGrossWeightUnit;
	}
	public Integer getItemQty() {
		return itemQty;
	}
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	public String getItemQtyUnit() {
		return itemQtyUnit;
	}
	public void setItemQtyUnit(String itemQtyUnit) {
		this.itemQtyUnit = itemQtyUnit;
	}
	public String getItemRemark() {
		return itemRemark;
	}
	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}
	@Override
	public String toString() {
		return "ReceivingItem [receivingID=" + receivingID + ", productId=" + productId + ", itemStatus=" + itemStatus
				+ ", orderId=" + orderId + ", partyId=" + partyId + ", itemCreateDate=" + itemCreateDate
				+ ", itemReceivingDate=" + itemReceivingDate + ", itemGrossWeight=" + itemGrossWeight
				+ ", itemGrossWeightUnit=" + itemGrossWeightUnit + ", itemQty=" + itemQty + ", itemQtyUnit="
				+ itemQtyUnit + ", itemRemark=" + itemRemark + "]";
	}
	
	
}
