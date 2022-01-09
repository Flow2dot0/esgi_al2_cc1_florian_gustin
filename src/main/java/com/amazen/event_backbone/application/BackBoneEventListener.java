package com.amazen.event_backbone.application;

import com.amazen.kernel.Event;
import com.amazen.kernel.EventListener;

import java.util.logging.Logger;

public class BackBoneEventListener implements EventListener<Event> {
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;

    public BackBoneEventListener(Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(Event event) {
        logger.info(String.format("Event incoming into BackBoneEventListener : %s",  event));
        backBoneEventHubManager.getEventLogService().add(event);
    }
}
