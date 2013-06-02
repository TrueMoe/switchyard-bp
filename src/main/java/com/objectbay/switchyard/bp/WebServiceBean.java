package com.objectbay.switchyard.bp;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

@Service(WebService.class)
public class WebServiceBean implements WebService {
	@Inject
	@Reference
	Router _router;

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		return _router.getStationReport(request);
	}

}
