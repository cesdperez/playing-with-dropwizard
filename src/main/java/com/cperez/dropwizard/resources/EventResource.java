package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import com.cperez.dropwizard.core.EventRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}