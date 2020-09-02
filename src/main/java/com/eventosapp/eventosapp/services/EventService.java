package com.eventosapp.eventosapp.services;

import com.eventosapp.eventosapp.exceptions.EventException;
import com.eventosapp.eventosapp.model.EventEntity;
import com.eventosapp.eventosapp.parameters.EventParameters;
import com.eventosapp.eventosapp.presenters.EventPresenter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    List<EventPresenter> getAll() throws EventException;

    EventPresenter create(EventEntity event) throws EventException;

    EventPresenter getByID(Long id) throws EventException;
}
