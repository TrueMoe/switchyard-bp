package com.objectbay.switchyard.bp;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;
import com.objectbay.switchyard.bp.domain.StationType;

@Service(WebService.class)
public class WebServiceBean implements WebService {
	@Inject
	@Reference
	private Router router;

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		request.setStationType(StationType.TYPE2);
		return router.getStationReport(request);
	}

}
