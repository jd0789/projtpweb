package com.example.demo;

import com.example.demo.livres.resource.LivreResource;
import com.example.demo.personnes.resource.PersonneResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfiguration extends ResourceConfig {
	
	public JerseyConfiguration() {
		register(PersonneResource.class);
		register(LivreResource.class);
	}
}
