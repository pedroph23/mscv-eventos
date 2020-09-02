package com.eventosapp.eventosapp.presenters;

import com.eventosapp.eventosapp.model.EventEntity;
import com.eventosapp.eventosapp.model.GuestEntity;

import java.io.Serializable;
import java.util.List;

public class EventPresenter implements Serializable {
    private Long id;

    private String name;

    private String location;

    private String date;

    private boolean actived;

    private List<GuestPresenter> guests;

    public EventPresenter(EventEntity eventEntity) {
        this.id = eventEntity.getId();
        this.name = eventEntity.getName();
        this.location = eventEntity.getLocation();
        this.date = eventEntity.getDate();
        this.actived = eventEntity.isActived();
        
        if(eventEntity != null && eventEntity.getGuests() != null && eventEntity.getGuests().size() > 0) {
            this.setGuests(new GuestPresenter().convertToGuestPresenter(eventEntity));
        }

    }

    public EventEntity toModel(EventEntity eventEntity) {

        this.setId(eventEntity.getId());
        this.setName(eventEntity.getName());
        this.setLocation(eventEntity.getLocation());
        this.setDate(eventEntity.getDate());
        this.setActived(eventEntity.isActived());

        eventEntity.setId(this.id);
        eventEntity.setName(this.name);
        eventEntity.setLocation(this.location);
        eventEntity.setDate(this.date);
        eventEntity.setActived(this.actived);

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

    public List<GuestPresenter> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestPresenter> guests) {
        this.guests = guests;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }
}
