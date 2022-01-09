package com.amazen.membership.application;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.Company;

public class CreateContractorEvent implements DomainEvent {
    private final MemberID id;
    private final Company company;

    public CreateContractorEvent(MemberID id, Company company) {
        this.id = id;
        this.company = company;
    }

    public MemberID getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "CreateContractorEvent{" +
                "id=" + id +
                ", company=" + company +
                '}';
    }
}
