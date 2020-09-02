package com.eventosapp.eventosapp.presenters;

import com.eventosapp.eventosapp.model.EventEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GuestPresenter implements Serializable {

    private Long id;

    private String name;

    private String rg;

    private List<EventEntity> eventEntitys;

    public GuestPresenter() {
    }

    public List<GuestPresenter> convertToGuestPresenter(EventEntity eventEntity) {
        List<GuestPresenter> guestPresenters = new ArrayList<>();

        eventEntity.getGuests().forEach(guestEntity -> {
            this.setId(guestEntity.getId());
            this.setName(guestEntity.getName());
            this.setRg(guestEntity.getRg());
            guestPresenters.add(this);
        });

        return guestPresenters;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<EventEntity> getEventEntitys() {
        return eventEntitys;
    }

    public void setEventEntitys(List<EventEntity> eventEntitys) {
        this.eventEntitys = eventEntitys;
    }
}
