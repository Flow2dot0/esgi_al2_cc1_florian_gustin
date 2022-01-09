package com.amazen.membership.domain;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.RecordEvent;
import com.amazen.membership.application.CreateTradesmanEvent;

import java.util.*;

public class Tradesman implements Entity<MemberID>, RecordEvent {

    private MemberID id;
    private List<DomainEvent> recordedEvents;

    private Address address;
    private FullName fullname;
    private List<Skill> skills;

    private Tradesman(MemberID id, List<DomainEvent> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public static Tradesman of(MemberID id, List<DomainEvent> recordedEvents) {
        final Tradesman tradesman = new Tradesman(id, new ArrayList<>());
        tradesman.hydrate(recordedEvents);
        return tradesman;
    }

    public static Tradesman create(MemberID id, DomainEvent event) {
        final Tradesman tradesman = new Tradesman(id, new ArrayList<>());
        tradesman.recordedEvents().add(event);
        tradesman.hydrate(List.of(event));
        return tradesman;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {}

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }

    private void hydrate(List<DomainEvent> events){
        events.forEach(event -> {
            if(event instanceof CreateTradesmanEvent){
                final CreateTradesmanEvent ev = (CreateTradesmanEvent) event;
                applyEvent(ev);
            }
        });
    }

    private void applyEvent(CreateTradesmanEvent createTradesmanEvent){
        this.fullname = createTradesmanEvent.fullname;
        this.address = createTradesmanEvent.address;
        this.skills = createTradesmanEvent.skills;
    }
}
