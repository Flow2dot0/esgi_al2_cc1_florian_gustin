package com.amazen.multipay.infrastructure.repository;

import com.amazen.core.entities.UniqueId;
import com.amazen.core.exceptions.ValueObjectException;
import com.amazen.marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen.multipay.domain.entities.Transaction;

public class TransactionInMemoryRepository extends InMemoryRepositoryEngine<UniqueId, Transaction> {
    public static final InMemoryRepositoryEngine<UniqueId, Transaction> INSTANCE = new TransactionInMemoryRepository();

    @Override
    protected UniqueId nextId() throws ValueObjectException {
        return UniqueId.withId(count.incrementAndGet());
    }

    @Override
    public Transaction findById(UniqueId uniqueId) {
        return data.get(uniqueId);
    }

    @Override
    public Transaction save(Transaction transaction) throws ValueObjectException {
        transaction.setId(transaction.getId() != null ? transaction.getId() : nextId());
        data.put(transaction.getId(), transaction);
        return data.get(transaction.getId());
    }

    @Override
    public void delete(Transaction transaction) {

    }
}
