package com.eventosapp.eventosapp.model;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "event", schema = "eventdb")
public class EventEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "date_begin")
    private String date;

    @Column(name = "active")
    private boolean actived;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "id_guest")
    private List<GuestEntity> guests;

    public List<GuestEntity> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestEntity> guests) {
        this.guests = guests;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }
}
