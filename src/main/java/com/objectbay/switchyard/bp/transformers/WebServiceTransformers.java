package com.objectbay.switchyard.bp.transformers;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.switchyard.annotations.Transformer;
import org.switchyard.exception.SwitchYardException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.objectbay.switchyard.bp.db.domain.GasStation;
import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;
import com.objectbay.switchyard.bp.domain.RequestType;

public final class WebServiceTransformers {

	@Transformer(to = "{urn:com.example.switchyard:switchyard-bp:1.0}getStationReportResponse")
	public Element transformReportResponseToGetStationReportResponse( ReportResponse from) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element response = document.createElement("getStationReportResponse");
			if (from.getStationType() != null) {
				Element element = document.createElement("stationType");
				element.setTextContent(from.getStationType().name());
				response.appendChild(element);
			}
			if (from.getGasStations() != null && from.getGasStations().size() > 0) {
				Element gasStations = createGasStationsElement(document, from.getGasStations());
				response.appendChild(gasStations);
			}
			return response;
		} catch (ParserConfigurationException e) {
			throw new SwitchYardException(e);
		}
	}

	private Element createGasStationsElement(Document document, List<GasStation> stations) {
		Element gasStations = document.createElement("gasStations");
		for (GasStation gasStation : stations) {
			Element station = document.createElement("gasStation");
			Element id = document.createElement("gasStation");
			id.setTextContent(Long.toString(gasStation.getId()));
			Element name = document.createElement("gasStation");
			name.setTextContent(gasStation.getName());
			station.appendChild(id);
			station.appendChild(name);
			gasStations.appendChild(station);
		}
		return gasStations;
	}

	@Transformer(from = "{urn:com.example.switchyard:switchyard-bp:1.0}getStationReport")
	public ReportRequest transformGetStationReportToReportRequest(Element from) {
		ReportRequest request = new ReportRequest();
		NodeList list = from.getElementsByTagName("stationType");
		if (list.getLength() > 0) {
			Node node = list.item(0);
			RequestType type = RequestType.valueOf(node.getTextContent());
			request.setStationType(type);
		}
		return request;
	}
}
