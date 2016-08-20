package com.mocircle.devsuite.backend.service.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pac4j.jwt.profile.JwtGenerator;
import org.pac4j.jwt.profile.JwtProfile;
import org.pac4j.springframework.security.authentication.Pac4jAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mocircle.devsuite.backend.core.model.Message;
import com.mocircle.devsuite.backend.core.service.MessageService;
import com.nimbusds.jose.EncryptionMethod;

@Path("/")
public class DemoResource {

	@Autowired
	private MessageService service;

	@Value("${jwt.secret}")
	private String jwtKey;

	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public Message showHelloMessage() {
		return service.getMessage();
	}

	@GET
	@Path("/secured/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public Message showSecuredMessage() {
		String userName = "";

		// Get user name from token
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth instanceof Pac4jAuthentication) {
			Pac4jAuthentication token = (Pac4jAuthentication) auth;
			if (token.getProfile() instanceof JwtProfile) {
				JwtProfile profile = (JwtProfile) token.getProfile();
				userName = profile.getAttribute("userName").toString();
			}
		}

		return service.getSecuredMessage(userName);
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@FormParam("userName") String userName, @FormParam("password") String password) {
		JwtGenerator<JwtProfile> gen = new JwtGenerator<>(jwtKey);
		gen.setEncryptionMethod(EncryptionMethod.A128CBC_HS256);

		JwtProfile profile = new JwtProfile();
		profile.addAttribute("userName", userName);

		return gen.generate(profile);
	}

}
