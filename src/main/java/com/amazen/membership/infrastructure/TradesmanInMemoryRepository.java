package com.amazen.membership.infrastructure;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.ValueObjectId;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;
import com.amazen.kernel.exceptions.NoSuchEntityException;
import com.amazen.membership.domain.Tradesman;

import java.util.*;


@Repository
public class TradesmanInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Tradesman, List<DomainEvent>> {

    @Override
    public MemberID nextID() {
        return new MemberID(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(MemberID memberID) {
        final List<DomainEvent> recordedEvents = data.get(memberID);
        if (recordedEvents == null) {
            throw NoSuchEntityException.withId((ValueObjectId) memberID);
        }
        return Tradesman.of(memberID, recordedEvents);
    }

    @Override
    public Collection<Tradesman> findAll() {
        List<Tradesman> result = new ArrayList<>();
        final Set<Map.Entry<MemberID, List<DomainEvent>>> entries = data.entrySet();
        for (Map.Entry<MemberID, List<DomainEvent>> entry : entries) {
            result.add(Tradesman.of(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    @Override
    public Tradesman save(Tradesman entity) {
        return null;
    }
}
