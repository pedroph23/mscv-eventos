package com.eventosapp.eventosapp.controller;

import com.eventosapp.eventosapp.exceptions.EventException;
import com.eventosapp.eventosapp.model.EventEntity;
import com.eventosapp.eventosapp.parameters.EventParameters;
import com.eventosapp.eventosapp.presenters.EventPresenter;
import com.eventosapp.eventosapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController (EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventPresenter>> getAll() throws EventException {
        List<EventPresenter> events = eventService.getAll();

        if(events == null || events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(events);
    }

    @PostMapping
    public ResponseEntity<EventParameters> create(@RequestBody EventParameters eventParameters) throws EventException {

        EventPresenter eventPresenter = eventService.create(eventParameters.toModel());

         if(eventPresenter != null) {
            return ResponseEntity.ok().build();
         }

         return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<EventParameters> update(@RequestBody EventParameters eventParameters) throws EventException {

        EventPresenter eventPresenter = eventService.create(eventParameters.toModel());

        if(eventPresenter != null) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EventPresenter> getByID(@PathVariable(value = "id") Long id) throws EventException {
        EventPresenter eventPresenter = eventService.getByID(id);

        if(eventPresenter == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(eventPresenter);
    }

}
