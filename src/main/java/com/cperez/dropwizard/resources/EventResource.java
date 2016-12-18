package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public interface EventResource {

    @GET
    List<Event> getEvents();

    @GET
    @Path("{id}")
    Event getEvent(@PathParam("id") LongParam id);
}