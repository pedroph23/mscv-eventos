package com.eventosapp.eventosapp.parameters;

import com.eventosapp.eventosapp.model.EventEntity;
import com.eventosapp.eventosapp.model.GuestEntity;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;

public class EventParameters implements Serializable {

    private Long id;

    private String name;

    private String location;

    private String date;

    private boolean actived;

    private List<GuestEntity> guests;


    public EventEntity toModel() {
        EventEntity eventEntity =  new EventEntity();

        eventEntity.setId(this.id);
        eventEntity.setName(this.name);
        eventEntity.setLocation(this.location);
        eventEntity.setDate(this.date);
        eventEntity.setActived(this.actived);
        eventEntity.setGuests(this.guests);

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

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public List<GuestEntity> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestEntity> guests) {
        this.guests = guests;
    }
}
