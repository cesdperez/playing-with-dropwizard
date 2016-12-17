package com.cperez.dropwizard;

import com.cperez.dropwizard.resources.EventResource;
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
        environment.jersey().register(new EventResource());
    }
}
