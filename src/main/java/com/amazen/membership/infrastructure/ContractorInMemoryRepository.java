package com.amazen.membership.infrastructure;


import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.ValueObjectId;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;
import com.amazen.kernel.exceptions.NoSuchEntityException;
import com.amazen.membership.domain.Contractor;

import java.util.*;

@Repository
public class ContractorInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Contractor, List<DomainEvent>> {

    @Override
    public MemberID nextID() {
        return new MemberID(count.incrementAndGet());
    }

    @Override
    public Contractor findById(MemberID memberID) {
        final List<DomainEvent> recordedEvents = data.get(memberID);
        if (recordedEvents == null) {
            throw NoSuchEntityException.withId((ValueObjectId) memberID);
        }
        return Contractor.of(memberID, recordedEvents);
    }

    @Override
    public Collection<Contractor> findAll() {
        List<Contractor> result = new ArrayList<>();
        final Set<Map.Entry<MemberID, List<DomainEvent>>> entries = data.entrySet();
        for (Map.Entry<MemberID, List<DomainEvent>> entry : entries) {
            result.add(Contractor.of(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    @Override
    public Contractor save(Contractor entity) {
        var domainEvents = data.get(entity.getId());
        if (domainEvents == null) {
            domainEvents = new ArrayList<>();
        }
        domainEvents.addAll(entity.recordedEvents());
        data.put(entity.getId(), domainEvents);
        return entity;
    }
}
