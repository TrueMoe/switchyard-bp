package com.objectbay.switchyard.bp;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	public void configure() {
		from("switchyard://Router")
		.log("Received message for 'Router' : ${body}")
		.choice()
			.when(simple("${body.stationType.toString} == 'DB'"))
				.log("get report -> CollectorService2")
				.to("switchyard://CollectorService2")
			.otherwise()
				.log("get report -> CollectorService1")
				.to("switchyard://CollectorService1");
		}
}
