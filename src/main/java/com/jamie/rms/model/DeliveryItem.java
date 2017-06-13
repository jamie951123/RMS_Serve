package com.jamie.rms.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


@Entity(name="DeliveryItem")
@Table(name="DeliveryItem")
public class DeliveryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DeliveryItemId")
	private Long DeliveryItemId;
	
	@Column(name = "productId")
    private Long productId;
	
	@Column(name = "itemStatus")
	@Enumerated(EnumType.STRING)
    private Status itemStatus;
	
	@Column(name = "orderId")
    private Long orderId;
	
	@Column(name = "partyId")
    private String partyId;
	
	@Column(name = "itemStockOutDate")
	private Date itemStockOutDate;
	
	@Column(name = "itemCreateDate")
    private Date itemCreateDate;
	
	@Column(name = "itemCreateBy")
	private String itemCreateBy;
	
	@Column(name = "itemCloseDate")
    private Date itemCloseDate;
	
	@Column(name = "itemRemark")
    private String itemRemark;
	
	@Column(name = "itemGrossWeight")
    private BigDecimal itemGrossWeight;
	
	@Column(name = "itemQty")
    private Integer itemQty;
	
	@Column(name = "receivingId")
    private Integer receivingId;
	
}