package com.eventosapp.eventosapp.parameters;

import com.eventosapp.eventosapp.model.EventEntity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

public class GuestParameters implements Serializable {

    private Long id;

    private String name;

    private String rg;

    private List<EventEntity> eventEntitys;

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
