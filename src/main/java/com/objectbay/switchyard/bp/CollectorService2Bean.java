package com.objectbay.switchyard.bp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.util.LinkedCaseInsensitiveMap;
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
	private GasStationService service;

	@Override
	public ReportResponse getStationReport(ReportRequest request) {
		List<Object> objects = service.getStations();
		List<GasStation> stations = toGasStations(objects);
		ReportResponse response = new ReportResponse(request.getStationType());
		response.setGasStations(stations);
		return response;
	}

	private List<GasStation> toGasStations(List<Object> objects) {
		List<GasStation> stations = new ArrayList<GasStation>(objects.size());
		for (Object object : objects) {
			@SuppressWarnings("unchecked")
			LinkedCaseInsensitiveMap<Object> entity = (LinkedCaseInsensitiveMap<Object>) object;
			System.out.println(entity.containsKey("id"));
			System.out.println(entity.containsKey("name"));
			
			System.out.println(entity.get("id").getClass());
			System.out.println(entity.get("name").getClass());
			
			Long id = Long.valueOf((Integer)entity.get("id"));
			String name = (String) entity.get("name");
			stations.add(new GasStation(id, name));
		}
		return stations;
	}
}
