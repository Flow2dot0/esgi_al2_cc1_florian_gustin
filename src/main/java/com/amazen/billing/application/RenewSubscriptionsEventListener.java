package com.amazen.billing.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;

import java.util.logging.Logger;

public class RenewSubscriptionsEventListener implements EventListener<RenewSubscriptionsEvent> {
    private final BillingManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;

    public RenewSubscriptionsEventListener(BillingManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(RenewSubscriptionsEvent event) {
        logger.info(String.format("Event incoming into RenewSubscriptionsEventListener : %s",  event));
        backBoneEventHubManager.getEventLogService().add(event);
        manager.getExpiringSubscriptions();
    }
}
