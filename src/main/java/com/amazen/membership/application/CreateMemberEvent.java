package com.amazen.membership.application;

import com.amazen.kernel.ApplicationEvent;
import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;

public class CreateMemberEvent implements ApplicationEvent {
    private final MemberID memberID;
    private final DomainEvent event;

    public CreateMemberEvent(MemberID memberID, DomainEvent event) {
        this.memberID = memberID;
        this.event = event;
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public DomainEvent getEvent() {
        return event;
    }
}
