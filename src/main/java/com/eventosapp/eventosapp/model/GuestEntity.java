package com.eventosapp.eventosapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "guest", schema = "eventdb")
public class GuestEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rg")
    private String rg;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
