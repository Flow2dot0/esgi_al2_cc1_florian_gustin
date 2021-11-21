package com.amazen.core;

import com.amazen.multipay.domain.interfaces.Observer;
import com.amazen.multipay.domain.interfaces.Subject;
import com.amazen.multipay.domain.entities.Transaction;

import java.util.Objects;

public class TransactionObserver implements Observer {

    private Subject subject;

    public Transaction getTransactionCallback() {
        return transactionCallback;
    }

    private Transaction transactionCallback;

    public TransactionObserver(Subject subject) {
        this.subject = Objects.requireNonNull(subject);
        this.subject.addObserver(this);
    }

    @Override
    public void update(Transaction transaction) {
        this.transactionCallback = Objects.requireNonNull(transaction);
    }
}
