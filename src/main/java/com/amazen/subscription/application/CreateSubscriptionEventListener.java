package com.amazen.subscription.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;
import com.amazen.subscription.domain.Subscription;

import java.util.Objects;
import java.util.logging.Logger;

public class CreateSubscriptionEventListener implements EventListener<CreateSubscriptionEvent> {
    private final SubscriptionManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;

    public CreateSubscriptionEventListener(SubscriptionManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(CreateSubscriptionEvent event) {
        if(Objects.nonNull(event.getMemberID())){
            manager.openPaymentTransaction(event);
            logger.info(String.format("Event incoming into CreateSubscriptionEventListener : %s",  event));
            backBoneEventHubManager.getEventLogService().add(event);
        }
    }
}
