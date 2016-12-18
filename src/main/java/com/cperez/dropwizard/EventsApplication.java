package com.cperez.dropwizard;

import com.cperez.dropwizard.core.DummyEventRepository;
import com.cperez.dropwizard.core.EventRepository;
import com.cperez.dropwizard.resources.EventResource;
import com.cperez.dropwizard.resources.EventResourceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EventsApplication extends Application<EventsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EventsApplication().run(args);
    }

    @Override
    public String getName() {
        return "Events";
    }

    @Override
    public void initialize(final Bootstrap<EventsConfiguration> bootstrap) {
    }

    @Override
    public void run(final EventsConfiguration configuration, final Environment environment) {
        setupObjectMapper(configuration, environment);
        setupResources(environment);
    }

    private void setupObjectMapper(EventsConfiguration configuration, Environment environment) {
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);
    }

    private void setupResources(Environment environment) {
        EventRepository repository = new DummyEventRepository();
        EventResource eventResource = new EventResourceImpl(repository);
        environment.jersey().register(eventResource);
    }
}
