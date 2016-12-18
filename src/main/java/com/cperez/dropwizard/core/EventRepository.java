package com.cperez.dropwizard.core;

import com.cperez.dropwizard.api.Event;
import io.dropwizard.jersey.params.LongParam;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

    Optional<Event> update(Long id, Event event);
}
