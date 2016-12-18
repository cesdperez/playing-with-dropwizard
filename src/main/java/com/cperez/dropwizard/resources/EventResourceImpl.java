package com.cperez.dropwizard.resources;

import com.cperez.dropwizard.api.Event;
import com.cperez.dropwizard.core.EventRepository;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.WebApplicationException;
import java.util.List;

public class EventResourceImpl implements EventResource {

    private EventRepository eventRepository;

    public EventResourceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(LongParam id) {
        return eventRepository
                .findById(id.get())
                .orElseThrow(() -> new WebApplicationException("Event not found", 404));
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
}