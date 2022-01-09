package com.amazen.billing.domain;

import com.amazen.kernel.Entity;

import java.time.LocalDate;

public class Transaction implements Entity<TransactionID> {
    private TransactionID id;
    private Amount amount;
    private Status status;
    private LocalDate date;

    public Transaction(TransactionID id, Amount amount, Status status, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    @Override
    public TransactionID getId() {
        return id;
    }

    public Amount getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setId(TransactionID transactionID) {
        throw new UnsupportedOperationException();
    }
}
