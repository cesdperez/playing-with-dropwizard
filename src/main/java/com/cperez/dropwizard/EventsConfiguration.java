package com.cperez.dropwizard;

import io.dropwizard.Configuration;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

public class EventsConfiguration extends Configuration {

    @NotEmpty
    @Getter
    private String dateFormat;
}
