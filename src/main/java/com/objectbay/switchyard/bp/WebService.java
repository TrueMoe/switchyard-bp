package com.objectbay.switchyard.bp;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

public interface WebService {

	ReportResponse getStationReport(ReportRequest request);
}
