package com.amazen.membership.application;

import com.amazen.event_backbone.domain.BackBoneEventHubService;
import com.amazen.kernel.EventListener;
import com.amazen.membership.domain.MembershipManager;

import java.util.Objects;
import java.util.logging.Logger;

@com.amazen.kernel.annotations.EventListener
public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    private final MembershipManager manager;
    private final Logger logger;
    private final BackBoneEventHubService eventLogService;


    public CreateMemberEventListener(MembershipManager manager, Logger logger, BackBoneEventHubService eventLogService) {
        this.manager = manager;
        this.logger = logger;
        this.eventLogService = eventLogService;
    }

    @Override
    public void listen(CreateMemberEvent event) {
        if(Objects.nonNull(event.getMemberID())){
            manager.getMemberService().createMember(event);
            logger.info(String.format("Event incoming into CreateMemberEventListener : %s",  event));
            eventLogService.add(event);
        }
    }
}
