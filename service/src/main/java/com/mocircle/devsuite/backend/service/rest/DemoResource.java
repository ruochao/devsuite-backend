package com.mocircle.devsuite.backend.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.mocircle.devsuite.backend.core.model.Message;
import com.mocircle.devsuite.backend.core.service.MessageService;

@Path("/")
public class DemoResource {

    @Autowired
    private MessageService service;

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Message showHelloMessage() {
        return service.getMessage();
    }

}
