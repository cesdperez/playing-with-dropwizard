package com.cperez.dropwizard.api;

import lombok.Data;

import java.util.Date;

@Data
public class Event {
    private long id;
    private String name;
    private String description;
    private String location;
    private Date date;

    public void updateExceptId(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.location = event.getLocation();
        this.date = event.getDate();
    }
}