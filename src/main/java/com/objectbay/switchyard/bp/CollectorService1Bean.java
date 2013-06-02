package com.objectbay.switchyard.bp;

import java.util.ArrayList;
import java.util.List;

import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.bp.db.domain.GasStation;
import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;

@Service(value = CollectorService.class, name = "CollectorService1")
public class CollectorService1Bean implements CollectorService {
	private static final List<GasStation> STATIONS = new ArrayList<GasStation>();
	static {
		STATIONS.add(new GasStation(1, "Unterweitersdorf"));
		STATIONS.add(new GasStation(2, "Hochfellen"));
		STATIONS.add(new GasStation(3, "Linz"));
		STATIONS.add(new GasStation(4, "Innsbruck"));
	}

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		ReportResponse response = new ReportResponse(request.getStationType());
		response.setGasStations(STATIONS);
		return response;
	}

}
