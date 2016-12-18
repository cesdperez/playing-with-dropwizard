package com.cperez.dropwizard.core;

import com.cperez.dropwizard.api.Event;

import java.util.List;

public interface EventRepository {

    List<Event> findAll();
}
