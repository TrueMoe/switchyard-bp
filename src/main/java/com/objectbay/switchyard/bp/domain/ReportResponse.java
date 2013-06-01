package com.objectbay.switchyard.bp.domain;

import com.objectbay.switchyard.bp.db.domain.GasStation;

import java.util.ArrayList;
import java.util.List;

public class ReportResponse {
	private RequestType stationType;
	private List<GasStation> gasStations;
	
	public ReportResponse() {
		gasStations = new ArrayList<GasStation>();
	}

	public ReportResponse(RequestType stationType) {
		this.stationType = stationType;
	}

	public RequestType getStationType() {
		return stationType;
	}

	public void setStationType(RequestType stationType) {
		this.stationType = stationType;
	}

	public List<GasStation> getGasStations() {
		return gasStations;
	}

	public void setGasStations(List<GasStation> gasStations) {
		this.gasStations = gasStations;
	}
}
