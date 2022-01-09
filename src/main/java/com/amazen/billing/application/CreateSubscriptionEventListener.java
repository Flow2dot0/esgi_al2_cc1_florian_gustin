package com.amazen.billing.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;

import java.util.Objects;
import java.util.logging.Logger;

public class CreateSubscriptionEventListener implements EventListener<CreateSubscriptionEvent> {
    private final BillingManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;

    public CreateSubscriptionEventListener(BillingManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(CreateSubscriptionEvent event) {
        if(Objects.nonNull(event.getMemberID())){
            logger.info(String.format("Event incoming into CreateSubscriptionEventListener : %s",  event));
            backBoneEventHubManager.getEventLogService().add(event);
            manager.openPaymentTransaction(event);
        }
    }
}
