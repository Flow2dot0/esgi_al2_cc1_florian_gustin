package com.amazen.event_backbone.domain;

import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.Event;
import com.amazen.kernel.Service;
import com.amazen.membership.application.CreateContractorEvent;
import com.amazen.membership.application.CreateTradesmanEvent;

import java.util.logging.Logger;

@com.amazen.kernel.annotations.Service
public class BackBoneEventLogService implements Service {

    private final EventLogInMemoryRepository repository;
    private final Logger logger;

    public BackBoneEventLogService(EventLogInMemoryRepository repository, Logger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public void add(Event event){
        final BackBoneEvent backBoneEvent = new BackBoneEvent(repository.nextID(), event);
        repository.add(backBoneEvent);
        logger.info(String.format("EventLogService saved event : %s", backBoneEvent));
    }

}
