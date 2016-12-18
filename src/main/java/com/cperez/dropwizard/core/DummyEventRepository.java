package com.cperez.dropwizard.core;

import com.cperez.dropwizard.api.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

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
}
