package com.jamie.rms.searchcriteria.object;


import com.jamie.rms.model.Status;

public class InventorySearchObject extends HomeSearchObject {

	 Status status;

	    public Status getStatus() {
	        return status;
	    }

	    public void setStatus(Status status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "InventorySearchObject{" +
	                "status=" + status +
	                '}';
	    }
	    
}
