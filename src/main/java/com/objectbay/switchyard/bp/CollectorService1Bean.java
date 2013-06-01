package com.objectbay.switchyard.bp;

import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

@Service(value = CollectorService.class, name = "CollectorService1")
public class CollectorService1Bean implements CollectorService {

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		return new ReportResponse(request.getStationType());
	}

}
