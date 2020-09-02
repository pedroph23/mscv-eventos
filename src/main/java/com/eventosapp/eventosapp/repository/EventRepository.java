package com.eventosapp.eventosapp.repository;

import com.eventosapp.eventosapp.model.EventEntity;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Query(value = "SELECT event FROM EventEntity event")
    List<EventEntity> getAll();

    Optional<EventEntity> findById(Long id);
}
