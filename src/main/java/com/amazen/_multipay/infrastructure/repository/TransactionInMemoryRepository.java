package com.amazen._multipay.infrastructure.repository;

import com.amazen._core.entities.UniqueId;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen._multipay.domain.entities.Transaction;

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
