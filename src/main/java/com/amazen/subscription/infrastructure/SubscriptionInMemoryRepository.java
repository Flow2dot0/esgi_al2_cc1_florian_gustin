package com.amazen.subscription.infrastructure;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;
import com.amazen.subscription.domain.Subscription;

import java.util.*;

public class SubscriptionInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Subscription, List<DomainEvent>> {
    @Override
    public MemberID nextID() {
        return null;
    }

    @Override
    public Subscription findById(MemberID memberID) {
        return null;
    }

    @Override
    public Collection<Subscription> findAll() {
        return null;
    }

    @Override
    public Subscription save(Subscription entity) {
        return null;
    }
}
