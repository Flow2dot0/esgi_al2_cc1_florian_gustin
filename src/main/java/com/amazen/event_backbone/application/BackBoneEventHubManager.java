package com.amazen.event_backbone.application;

import com.amazen.event_backbone.domain.BackBoneEventLogService;
import com.amazen.kernel.annotations.Manager;

@Manager
public class BackBoneEventHubManager {

    private final BackBoneEventLogService eventLogService;

    public BackBoneEventHubManager(BackBoneEventLogService eventLogService) {
        this.eventLogService = eventLogService;
    }

    public BackBoneEventLogService getEventLogService() {
        return eventLogService;
    }
}
