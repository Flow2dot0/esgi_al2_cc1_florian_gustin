package com.amazen._marketplace.domain.entities;

import com.amazen._core.entities.UniqueId;

import java.util.Objects;

public class Membership{

    public UniqueId getId() {
        return id;
    }

    public UniqueId getAccountId() {
        return accountId;
    }

    public UniqueId getTransactionId() {
        return transactionId;
    }

    public void setId(UniqueId id) {
        this.id = Objects.requireNonNull(id);
    }

    private UniqueId id;
    private UniqueId accountId;
    private UniqueId transactionId;

    public Membership(UniqueId accountId, UniqueId transactionId) {
        this.accountId = accountId;
        this.transactionId = transactionId;
    }
}
