package com.jamie.rms.searchcriteria.object;

import com.jamie.rms.model.Status;

public class HomeSearchObject {
	
	private String partyId;
	private Long id;
	private Status status;
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "HomeSearchObject [partyId=" + partyId + ", id=" + id + ", status=" + status + "]";
	}
	
	
	
}
