package com.objectbay.switchyard.bp.transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.switchyard.annotations.Transformer;

import com.objectbay.switchyard.bp.db.domain.GasStation;

public class GasStationServiceTransformer {

	@Transformer
	public GasStation[] from(ArrayList<Map<String, Object>> objects) {
		List<GasStation> stations = new ArrayList<GasStation>(objects.size());
		for (Map<String, Object> entity : objects) {
			Long id = Long.valueOf((Integer) entity.get("id"));
			String name = (String) entity.get("name");
			stations.add(new GasStation(id, name));
		}
		return stations.toArray(new GasStation[] {});
	}
}
