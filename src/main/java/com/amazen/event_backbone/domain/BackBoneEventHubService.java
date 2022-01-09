package com.amazen.event_backbone.domain;

import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.Event;
import com.amazen.kernel.Service;
import com.amazen.membership.application.CreateContractorEvent;
import com.amazen.membership.application.CreateTradesmanEvent;

import java.util.logging.Logger;

@com.amazen.kernel.annotations.Service
public class BackBoneEventHubService implements Service {

    private final EventLogInMemoryRepository repository;
    private final Logger logger;

    public BackBoneEventHubService(EventLogInMemoryRepository repository, Logger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public void add(Event event){
        final BackBoneEvent backBoneEvent = new BackBoneEvent(repository.nextID(), event);
        repository.add(backBoneEvent);
        logger.info(String.format("EventLogService saved event : %s", backBoneEvent));

        if(event instanceof CreateTradesmanEvent){

        }else if(event instanceof CreateContractorEvent){

        }
    }

}
