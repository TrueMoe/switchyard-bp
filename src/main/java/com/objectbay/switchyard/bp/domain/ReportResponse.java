package com.objectbay.switchyard.bp.domain;

import com.objectbay.switchyard.bp.db.domain.GasStation;

import java.util.ArrayList;
import java.util.List;

public class ReportResponse {
	private RequestType _stationType;
	private List<GasStation> _gasStations;
	
	public ReportResponse() {
		_gasStations = new ArrayList<GasStation>();
	}

	public ReportResponse(RequestType stationType) {
		this._stationType = stationType;
	}

	public RequestType getStationType() {
		return _stationType;
	}

	public void setStationType(RequestType stationType) {
		this._stationType = stationType;
	}

	public List<GasStation> getGasStations() {
		return _gasStations;
	}

	public void setGasStations(List<GasStation> gasStations) {
		this._gasStations = gasStations;
	}
}
