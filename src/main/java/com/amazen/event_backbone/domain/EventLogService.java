package com.amazen.event_backbone.domain;

import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.Event;
import com.amazen.kernel.Service;

import java.util.*;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.Service
public class EventLogService implements Service {

    private final EventLogInMemoryRepository repository;
    private final Logger logger;

    private EventLogService(EventLogInMemoryRepository repository, Logger logger) {
        this.repository = Objects.requireNonNull(repository);
        this.logger = Objects.requireNonNull(logger);
    }

    public static EventLogService of(EventLogInMemoryRepository repository, Logger logger) {
        return new EventLogService(repository, logger);
    }

    public Collection<Event> findAll(){
        return repository.findAll();
    }

    public Event save(Event event){
        return repository.save(event);
    }
}
