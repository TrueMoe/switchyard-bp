package com.objectbay.switchyard.bp.domain;

public class ReportRequest {
	RequestType stationType;
	
	public ReportRequest() { }
	
	public ReportRequest(RequestType stationType) {
			setStationType(stationType);
	}

	public void setStationType(RequestType type) {
		this.stationType = type;
	}

	public RequestType getStationType() {
		return stationType;
	}
}
