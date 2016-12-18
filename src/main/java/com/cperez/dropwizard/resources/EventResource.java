package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import com.cperez.dropwizard.core.EventRepository;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    private EventRepository eventRepository;

    public EventResource(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GET
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }

    @GET
    @Path("{id}")
    public Event getEvent(@PathParam("id") LongParam id) {
        return eventRepository
                .findById(id.get())
                .orElseThrow(() -> new WebApplicationException("Event not found", 404));
    }
}