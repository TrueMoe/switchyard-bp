package com.objectbay.switchyard.bp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;
import com.objectbay.switchyard.bp.domain.RequestType;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class WebServiceTest {

	@ServiceOperation("WebService")
	private Invoker service;

	@Test
	public void testGetStationReport() throws Exception {
		ReportRequest message = new ReportRequest();
		message.setStationType(RequestType.STATIC);
		
		ReportResponse result = service.operation("getStationReport")
				.sendInOut(message).getContent(ReportResponse.class);
		Assert.assertNotNull(result);
		Assert.assertEquals(RequestType.STATIC, result.getStationType());
	}

}
