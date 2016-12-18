package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    Event addEvent(Event event);

    @PUT
    @Path("{id}")
    Event updateEvent(@PathParam("id") LongParam id, Event event);

    @DELETE
    @Path("{id}")
    Response deleteEvent(@PathParam("id") LongParam id);
}