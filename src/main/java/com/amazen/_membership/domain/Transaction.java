package com.amazen._membership.domain;

import com.amazen._kernel.abstracts.Entity;
import com.amazen._kernel.value_objects.Amount;

import java.time.LocalDate;

public class Transaction implements Entity<TransactionId> {
    private TransactionId id;
    private Amount amount;
    private String source;
    private LocalDate date;

    private Transaction(TransactionId id, Amount amount, String source, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    static Transaction withAmount(Amount amount){
        return new Transaction(null, amount, null, null);
    }

    @Override
    public TransactionId getId() {
        return null;
    }

    @Override
    public void setId(TransactionId transactionId) {
        id = transactionId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
