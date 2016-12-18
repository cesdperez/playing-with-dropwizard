package com.cperez.dropwizard.core;

import com.cperez.dropwizard.api.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    List<Event> findAll();

    Optional<Event> findById(Long id);
}
