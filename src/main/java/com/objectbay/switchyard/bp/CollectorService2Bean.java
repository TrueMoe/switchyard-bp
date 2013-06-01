package com.objectbay.switchyard.bp;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.db.dao.GasStationService;
import com.objectbay.switchyard.bp.db.domain.GasStation;
import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

@Service(value = CollectorService.class, name = "CollectorService2")
public class CollectorService2Bean implements CollectorService {
	@Inject
	@Reference
	GasStationService service;

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		GasStation s = new GasStation();
		s.setId(1);
		GasStation station = service.getStation(s);
		System.out.println(station);
		
		return new ReportResponse(request.getStationType());
	}
}
