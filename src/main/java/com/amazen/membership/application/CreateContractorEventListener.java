package com.amazen.membership.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;

import java.util.Objects;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.EventListener
public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    private final MembershipManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;

    public CreateContractorEventListener(MembershipManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(CreateContractorEvent event) {
        if(Objects.nonNull(event.getId())){
            manager.getContractorService().createContractor(event);
            logger.info(String.format("Event incoming into CreateContractorEventListener : %s",  event));
            backBoneEventHubManager.getEventLogService().add(event);
        }
    }
}
