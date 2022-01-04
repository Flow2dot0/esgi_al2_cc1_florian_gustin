package com.amazen.membership.infrastructure;

import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.inmemory.InMemoryRepositoryEngine;
import com.amazen.membership.domain.Tradesman;
import com.amazen.membership.domain.TradesmanId;

import java.util.Objects;

@Repository
public class TradesmanInMemoryRepository extends InMemoryRepositoryEngine<TradesmanId, Tradesman> {
    private static final InMemoryRepositoryEngine<TradesmanId, Tradesman> INSTANCE = new TradesmanInMemoryRepository();

    @Override
    public Tradesman save(Tradesman tradesman) {
        tradesman.setId(Objects.nonNull(tradesman.getId()) ? tradesman.getId() : nextId());
        data.put(tradesman.getId(), tradesman);
        return data.get(tradesman.getId());
    }

    @Override
    public void delete(Tradesman tradesman) {
        data.remove(tradesman.getId());
    }

    @Override
    public InMemoryRepositoryEngine<TradesmanId, Tradesman> getInstance() {
        return INSTANCE;
    }

    @Override
    protected TradesmanId nextId() {
        return TradesmanId.of(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanId tradesmanId) {
        return data.get(tradesmanId);
    }
}
