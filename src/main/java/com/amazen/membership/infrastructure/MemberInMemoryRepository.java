package com.amazen.membership.infrastructure;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.ValueObjectId;
import com.amazen.kernel.exceptions.NoSuchEntityException;
import com.amazen.membership.domain.Member;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;

import java.util.*;

@Repository
public class MemberInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Member, List<DomainEvent>> {

    @Override
    public MemberID nextID() {
        return new MemberID(count.incrementAndGet());
    }

    @Override
    public Member findById(MemberID memberID) {
        final List<DomainEvent> recordedEvents = data.get(memberID);
        if (recordedEvents == null) {
            throw NoSuchEntityException.withId((ValueObjectId) memberID);
        }
        return Member.of(memberID, recordedEvents);
    }

    @Override
    public Collection<Member> findAll() {
        List<Member> result = new ArrayList<>();
        final Set<Map.Entry<MemberID, List<DomainEvent>>> entries = data.entrySet();
        for (Map.Entry<MemberID, List<DomainEvent>> entry : entries) {
            result.add(Member.of(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    @Override
    public Member save(Member entity) {
        var domainEvents = data.get(entity.getId());
        if (domainEvents == null) {
            domainEvents = new ArrayList<>();
        }
        domainEvents.addAll(entity.recordedEvents());
        data.put(entity.getId(), domainEvents);
        System.out.printf("create member : %s%n", data);

        return entity;
    }


}
