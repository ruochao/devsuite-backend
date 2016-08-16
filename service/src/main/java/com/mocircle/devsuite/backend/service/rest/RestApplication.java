package com.mocircle.devsuite.backend.service.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {

	public RestApplication() {
		register(DemoResource.class);
	}

}
