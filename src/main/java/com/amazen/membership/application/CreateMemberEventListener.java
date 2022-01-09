package com.amazen.membership.application;

import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.kernel.EventListener;

import java.util.Objects;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.EventListener
public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    private final MembershipManager manager;
    private final Logger logger;
    private final BackBoneEventHubManager backBoneEventHubManager;


    public CreateMemberEventListener(MembershipManager manager, Logger logger, BackBoneEventHubManager backBoneEventHubManager) {
        this.manager = manager;
        this.logger = logger;
        this.backBoneEventHubManager = backBoneEventHubManager;
    }

    @Override
    public void listen(CreateMemberEvent event) {
        if(Objects.nonNull(event.getMemberID())){
            manager.getMemberService().createMember(event);
            logger.info(String.format("Event incoming into CreateMemberEventListener : %s",  event));
            backBoneEventHubManager.getEventLogService().add(event);
        }
    }
}
