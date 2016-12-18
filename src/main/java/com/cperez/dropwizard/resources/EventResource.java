package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
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

    @POST
    public Event addEvent(Event event);
}