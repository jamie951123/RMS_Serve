package com.jamie.rms.searchcriteria.object;

public class InventorySearchObject extends HomeSearchObject {

	private Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "InventorySearchObject [productId=" + productId + "]";
	}
	
	
	    
}
