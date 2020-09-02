package com.eventosapp.eventosapp.services.impl;

import com.eventosapp.eventosapp.exceptions.EventException;
import com.eventosapp.eventosapp.model.EventEntity;
import com.eventosapp.eventosapp.presenters.EventPresenter;
import com.eventosapp.eventosapp.repository.EventRepository;
import com.eventosapp.eventosapp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventPresenter> getAll() throws EventException {

        try {
            List<EventPresenter> eventPresenters = new ArrayList<>();

            List<EventEntity> events = eventRepository.getAll();

            if (!events.isEmpty()) {
                events.forEach(e -> {
                    eventPresenters.add(new EventPresenter((e)));
                });
                return eventPresenters;
            }
            return null;
        } catch (HttpClientErrorException.BadRequest err) {
            throw new EventException("Erro no serviço, tente mais tarde");
        }
    }

    @Override
    public EventPresenter create(EventEntity event) throws EventException {
        try {
            EventPresenter eventPresenter;

            if (event.getId() == null) {
                event.setActived(true);
                return new EventPresenter(eventRepository.save(event));
            }

            try {
                EventPresenter eventPresenter1 = getByID(event.getId());
                return new EventPresenter(eventRepository.save(eventPresenter1.toModel(event)));
            } catch (Exception e) {
                throw new EventException("Erro no serviço, tente mais tarde");
            }


        } catch(HttpClientErrorException err) {
            throw new EventException("Erro no serviço, tente mais tarde");
        }
    }


    @Override
    public EventPresenter getByID(Long id) throws EventException {
        try {
            Optional<EventEntity> eventEntity = eventRepository.findById(id);
            if (!eventEntity.isEmpty()) {
                return new EventPresenter(eventEntity.get());
            }
            return null;
        } catch (HttpClientErrorException err) {
            throw new EventException("Erro no serviço, tente mais tarde");
        }

    }
}
