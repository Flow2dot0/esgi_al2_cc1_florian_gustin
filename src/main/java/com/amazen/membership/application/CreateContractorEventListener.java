package com.amazen.membership.application;

import com.amazen.event_backbone.domain.BackBoneEventHubService;
import com.amazen.kernel.EventListener;
import com.amazen.membership.domain.MembershipManager;

import java.util.Objects;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.EventListener
public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    private final MembershipManager manager;
    private final Logger logger;
    private final BackBoneEventHubService eventLogService;

    public CreateContractorEventListener(MembershipManager manager, Logger logger, BackBoneEventHubService eventLogService) {
        this.manager = manager;
        this.logger = logger;
        this.eventLogService = eventLogService;
    }

    @Override
    public void listen(CreateContractorEvent event) {
        if(Objects.nonNull(event.getId())){
            manager.getContractorService().createContractor(event);
            logger.info(String.format("Event incoming into CreateContractorEventListener : %s",  event));
            eventLogService.add(event);
        }
    }
}
