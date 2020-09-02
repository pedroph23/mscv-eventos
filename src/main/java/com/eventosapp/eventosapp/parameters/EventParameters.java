package com.eventosapp.eventosapp.parameters;

import com.eventosapp.eventosapp.model.EventEntity;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;

public class EventParameters implements Serializable {

    private Long id;

    private String name;

    private String location;

    private String date;

    public EventEntity toModel() {
        EventEntity eventEntity =  new EventEntity();

        eventEntity.setId(this.id);
        eventEntity.setName(this.name);
        eventEntity.setLocation(this.location);
        eventEntity.setDate(this.date);

        return eventEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
