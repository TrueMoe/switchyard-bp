package com.objectbay.switchyard.bp.domain;

public class ReportRequest {
	StationType stationType;
	
	public ReportRequest() { }
	
	public ReportRequest(StationType stationType) {
			setStationType(stationType);
	}

	public void setStationType(StationType type) {
		this.stationType = type;
	}

	public StationType getStationType() {
		return stationType;
	}
}
