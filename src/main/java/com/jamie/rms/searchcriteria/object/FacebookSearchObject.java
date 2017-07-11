package com.jamie.rms.searchcriteria.object;

public class FacebookSearchObject extends HomeSearchObject{

	private String facebookId;

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	@Override
	public String toString() {
		return "FacebookSearchObject [facebookId=" + facebookId + "]";
	}

	
	
}
