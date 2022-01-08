package com.amazen.membership.domain.old;

import com.amazen._kernel.abstracts.Entity;
import com.amazen._kernel.value_objects.Name;
import com.amazen.kernel.DomainEvent;
import com.amazen.membership.domain.cc2.Company;
import com.amazen.membership.domain.cc2.Password;

import java.util.List;


public class Contractor implements Entity<ContractorId> {
    private ContractorId id;
    private final Name name;
    private final Password password;
    private final Company company;
    private final List<DomainEvent> recordedEvents;

    public Contractor(List<DomainEvent> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }

    static Contractor of(ContractorId id, List<DomainEvent> recordedEvents) {
        final Contractor contractor = new
        return new Contractor(name, company);
    }

    @Override
    public ContractorId getId() {
        return id;
    }

    @Override
    public void setId(ContractorId id) {
        this.id = id;
    }

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
