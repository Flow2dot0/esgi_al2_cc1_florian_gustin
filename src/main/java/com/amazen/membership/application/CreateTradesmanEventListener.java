package com.amazen.membership.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;

import java.util.Objects;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.EventListener
public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    private final MembershipManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;


    public CreateTradesmanEventListener(MembershipManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(CreateTradesmanEvent event) {
        if(Objects.nonNull(event.id)){
            manager.getTradesmanService().createTradesman(event);
            logger.info(String.format("Event incoming into CreateTradesmanEventListener : %s",  event));
            backBoneEventHubManager.getEventLogService().add(event);
        }
    }
}
