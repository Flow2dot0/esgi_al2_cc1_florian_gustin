package com.amazen.membership.domain;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.RecordEvent;
import com.amazen.membership.application.CreateContractorEvent;

import java.util.ArrayList;
import java.util.List;

public class Contractor implements Entity<MemberID>, RecordEvent {

    private MemberID id;
    private List<DomainEvent> recordedEvents;

    private Company company;

    private Contractor(MemberID id, List<DomainEvent> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public static Contractor of(MemberID id, List<DomainEvent> recordedEvents) {
        final Contractor contractor = new Contractor(id, new ArrayList<>());
        contractor.hydrate(recordedEvents);
        return contractor;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {
        id = memberID;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }

    private void hydrate(List<DomainEvent> events){
        events.forEach(event -> {
            if(event instanceof CreateContractorEvent){
                applyEvent((CreateContractorEvent) event);
            }
        });
    }

    private void applyEvent(CreateContractorEvent createContractorEvent){
        this.company = createContractorEvent.getCompany();
    }
}
