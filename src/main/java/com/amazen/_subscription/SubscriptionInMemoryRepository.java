package com.amazen._subscription;

import com.amazen._kernel.annotations.Repository;
import com.amazen._kernel.engines.InMemoryRepositoryEngine;
import com.amazen._membership.domain.Tradesman;
import com.amazen._membership.domain.TradesmanId;

import java.util.Collection;
import java.util.Objects;

@Repository
public class SubscriptionInMemoryRepository extends InMemoryRepositoryEngine<TradesmanId, Tradesman> {

    @Override
    public Tradesman save(Tradesman tradesman) {
        tradesman.setId(Objects.nonNull(tradesman.getId()) ? tradesman.getId() : nextId());
        data.put(tradesman.getId(), tradesman);
        return data.get(tradesman.getId());
    }

    @Override
    public void delete(TradesmanId tradesmanId) {
        data.remove(tradesmanId);
    }

    @Override
    protected TradesmanId nextId() {
        return TradesmanId.of(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanId tradesmanId) {
        return data.get(tradesmanId);
    }

    @Override
    public Collection<Tradesman> findAll() {
        return data.values();
    }
}
