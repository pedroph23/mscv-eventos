package com.eventosapp.eventosapp.presenters;

import com.eventosapp.eventosapp.model.EventEntity;

import java.io.Serializable;

public class EventPresenter implements Serializable {
    private Long id;

    private String name;

    private String location;

    private String date;

    public EventPresenter(EventEntity eventEntity) {
        this.id = eventEntity.getId();
        this.name = eventEntity.getName();
        this.location = eventEntity.getLocation();
        this.date = eventEntity.getDate();
    }

    public EventEntity toModel(EventEntity eventEntity) {

        this.setId(eventEntity.getId());
        this.setName(eventEntity.getName());
        this.setLocation(eventEntity.getLocation());
        this.setDate(eventEntity.getDate());

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
