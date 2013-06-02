package com.objectbay.switchyard.bp;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.db.domain.GasStation;
import com.objectbay.switchyard.bp.db.service.GasStationService;
import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

@Service(value = CollectorService.class, name = "CollectorService2")
public class CollectorService2Bean implements CollectorService {
	@Inject
	@Reference
	private GasStationService _service;

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		List<GasStation> stations = Arrays.asList(_service.getStations());
		ReportResponse response = new ReportResponse(request.getStationType());
		response.setGasStations(stations);
		return response;
	}
}
