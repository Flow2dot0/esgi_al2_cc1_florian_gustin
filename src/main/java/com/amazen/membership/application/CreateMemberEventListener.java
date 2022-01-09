package com.amazen.membership.application;

import com.amazen.kernel.EventListener;
import com.amazen.membership.domain.MembershipManager;

import java.util.Objects;

@com.amazen.kernel.annotations.EventListener
public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    private final MembershipManager manager;

    public CreateMemberEventListener(MembershipManager manager) {
        this.manager = manager;
    }

    @Override
    public void listen(CreateMemberEvent event) {
        if(Objects.nonNull(event.getMemberID())){
            manager.getMemberService().createMember(event);
        }
    }
}
