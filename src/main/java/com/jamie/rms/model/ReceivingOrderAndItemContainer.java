package com.jamie.rms.model;

import java.util.List;

public class ReceivingOrderAndItemContainer{
    private ReceivingOrder receivingOrderModel;
    private List<ReceivingItem> receivingItemModelList;

    public ReceivingOrderAndItemContainer() {
    }

    

    public ReceivingOrder getReceivingOrderModel() {
		return receivingOrderModel;
	}



	public void setReceivingOrderModel(ReceivingOrder receivingOrderModel) {
		this.receivingOrderModel = receivingOrderModel;
	}



	public List<ReceivingItem> getReceivingItemModelList() {
		return receivingItemModelList;
	}



	public void setReceivingItemModelList(List<ReceivingItem> receivingItemModelList) {
		this.receivingItemModelList = receivingItemModelList;
	}



	@Override
    public String toString() {
        return "ReceivingOrderAndItemContainer{" +
                "receivingOrderModel=" + receivingOrderModel +
                ", receivingItemModelList=" + receivingItemModelList +
                '}';
    }
}
