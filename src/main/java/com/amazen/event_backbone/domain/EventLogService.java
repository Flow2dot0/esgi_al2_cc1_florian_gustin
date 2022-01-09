package com.amazen.event_backbone.domain;

import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.Event;
import com.amazen.kernel.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

@com.amazen.kernel.annotations.Service
public class EventLogService implements Service {

    private final EventLogInMemoryRepository repository;
    private final Logger logger;
    private final ObjectMapper mapper;

    public EventLogService(EventLogInMemoryRepository repository, Logger logger, ObjectMapper mapper) {
        this.repository = repository;
        this.logger = logger;
        this.mapper = mapper;
    }

    public void add(Event event){
        repository.add(new EventLog(event.toString()));
        logger.info(String.format("EventLogService saved event : %s", event));
    }

}
