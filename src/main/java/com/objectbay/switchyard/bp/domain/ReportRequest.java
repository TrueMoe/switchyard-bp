package com.objectbay.switchyard.bp.domain;

public class ReportRequest {
	RequestType _stationType;
	
	public ReportRequest() { }
	
	public ReportRequest(RequestType stationType) {
			setStationType(stationType);
	}

	public void setStationType(RequestType type) {
		this._stationType = type;
	}

	public RequestType getStationType() {
		return _stationType;
	}
}
