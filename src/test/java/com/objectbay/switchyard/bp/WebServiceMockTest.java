package com.objectbay.switchyard.bp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.objectbay.switchyard.bp.domain.ReportRequest;
import com.objectbay.switchyard.bp.domain.ReportResponse;
import com.objectbay.switchyard.bp.domain.RequestType;

public class WebServiceMockTest {

	ReportRequest request;
	private Router router;

	@Before
	public void before() {
		request = new ReportRequest();
		
		this.router = Mockito.mock(Router.class);
		Mockito.when(router.getStationReport(request)).thenReturn(new ReportResponse(RequestType.DB));
	}

	@Test
	public void testGetStationReport() throws Exception {
		WebServiceBean bean = new WebServiceBean();
		// set mock object
		bean._router = router;

		ReportResponse result = bean.getStationReport(request);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(RequestType.DB, result.getStationType());
	}
}
