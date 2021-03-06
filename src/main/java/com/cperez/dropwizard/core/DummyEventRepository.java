package com.cperez.dropwizard.core;

import com.cperez.dropwizard.api.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.io.Resources;
import io.dropwizard.jersey.params.LongParam;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Charsets.UTF_8;

public class DummyEventRepository implements EventRepository {

    private static final String DATA_SOURCE = "dummy_data.json";

    private List<Event> events;

    public DummyEventRepository() {
        initData();
    }

    @Override
    public List<Event> findAll() {
        return events;
    }

    @Override
    public Optional<Event> findById(Long id) {
        return events.stream()
                .filter(event -> id.equals(event.getId()))
                .findFirst();
    }

    @Override
    public Event save(Event event) {
        event.setId(getNextId());
        events.add(event);
        return event;
    }

    @Override
    public Optional<Event> update(Long id, Event newEvent) {
        Optional<Event> oldEvent = findById(id);
        oldEvent.ifPresent(e -> e.updateExceptId(newEvent));
        return oldEvent;
    }

    @Override
    public void delete(Long id) {
        events.removeIf(e -> e.getId() == id);
    }

    private void initData() {
        String jsonDataSource = toString(DATA_SOURCE);
        events = parse(jsonDataSource);
    }

    private String toString(String jsonPath) {
        try {
            URL url = Resources.getResource(jsonPath);
            return Resources.toString(url, UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(String.format("%s is missing", jsonPath), e);
        }
    }

    private List<Event> parse(String jsonDataSource) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            CollectionType type = mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, Event.class);

            return mapper.readValue(jsonDataSource, type);
        } catch (IOException e) {
            throw new RuntimeException(String.format("error while parsing %s", DATA_SOURCE), e);
        }
    }

    private long getNextId() {
        Optional<Long> maxId = events.stream()
                .map(Event::getId)
                .max(Long::compare);

        return maxId.map(x -> x + 1).orElse(1L);
    }
}
