package com.amazen.billing.infrastructure;

import com.amazen.kernel.*;
import com.amazen.billing.domain.Subscription;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SubscriptionInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Subscription, List<DomainEvent>> {
    @Override
    public MemberID nextID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Subscription findById(MemberID memberID) {
        final List<DomainEvent> recordedEvents = data.get(memberID);
        if (recordedEvents == null) {
            throw NoSuchEntityException.withId((ValueObjectId) memberID);
        }
        return Subscription.of(memberID, recordedEvents);
    }

    @Override
    public Collection<Subscription> findAll() {
        List<Subscription> result = new ArrayList<>();
        final Set<Map.Entry<MemberID, List<DomainEvent>>> entries = data.entrySet();
        for (Map.Entry<MemberID, List<DomainEvent>> entry : entries) {
            result.add(Subscription.of(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    @Override
    public Subscription save(Subscription entity) {
        var domainEvents = data.get(entity.getId());
        if (domainEvents == null) {
            domainEvents = new ArrayList<>();
        }
        domainEvents.addAll(entity.recordedEvents());
        data.put(entity.getId(), domainEvents);
        return entity;
    }

    public Collection<Subscription> findAllToRenew(){
        Collection<Subscription> subscriptions = findAll();
        subscriptions = subscriptions.stream().filter(subscription -> {
            return LocalDate.now().isEqual(subscription.getDate().plusMonths(1));
        }).collect(Collectors.toList());
        return subscriptions;
    }
}
