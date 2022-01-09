package com.amazen.membership.domain;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.RecordEvent;
import com.amazen.membership.application.CreateMemberEvent;

import java.util.*;

public class Member implements Entity<MemberID>, RecordEvent {

    private MemberID id;
    private List<DomainEvent> recordedEvents;

    private Email email;
    private Password password;


    private Member(MemberID id, List<DomainEvent> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public static Member of(MemberID id, List<DomainEvent> recordedEvents) {
        final Member member = new Member(id, new ArrayList<>());
        member.hydrate(recordedEvents);
        return member;
    }

    public static Member create(MemberID id, DomainEvent initialEvent){
        final Member member = new Member(id, new ArrayList<>());
        member.recordedEvents().add(initialEvent);
        member.hydrate(List.of(initialEvent));
        return member;
    }

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }


    private void hydrate(List<DomainEvent> events){
        events.forEach(event -> {
            if(event instanceof CreateMemberEvent){
                final CreateMemberEvent ev = (CreateMemberEvent) event;
                applyEvent(ev);
            }
        });
    }

    private void applyEvent(CreateMemberEvent createMemberEvent){
        this.email = createMemberEvent.getEmail();
        this.password = createMemberEvent.getPassword();
    }


    public Member(MemberID memberID, Email email, Password password) {
        this.id = memberID;
        this.email = email;
        this.password = password;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {
        id = memberID;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

}
