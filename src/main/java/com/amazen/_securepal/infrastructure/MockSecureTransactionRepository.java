package com.amazen._securepal.infrastructure;

import com.amazen._kernel.abstracts.Repository;
import com.amazen._securepal.domain.Transaction;
import com.amazen._securepal.domain.TransactionId;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class MockSecureTransactionRepository implements Repository<TransactionId, Transaction> {
    @Override
    public Transaction findById(TransactionId transactionId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Transaction> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Transaction save(Transaction transaction) {
        System.out.println("SECURE PAL RECORDING TRANSACTION");
        UUID token = UUID.randomUUID();
        transaction.setId(new TransactionId(token.hashCode()));
        transaction.setDate(LocalDate.now());
        transaction.setSource("securepal");
        return transaction;
    }

    @Override
    public void delete(TransactionId transactionId) {
        throw new UnsupportedOperationException();
    }

}
