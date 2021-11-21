package com.amazen.multipay.domain.entities;


import com.amazen.core.interfaces.DateEngine;
import com.amazen.core.entities.UniqueId;
import com.amazen.multipay.domain.enums.TransactionStatus;

import java.util.Objects;

public class Transaction{
    public Transaction(String source, TransactionStatus status, DateEngine createdOn) {
        this.source = Objects.requireNonNull(source);
        this.status = Objects.requireNonNull(status);
        this.createdOn = Objects.requireNonNull(createdOn);
    }

    public Transaction(String source, TransactionStatus status, DateEngine createdOn, String token, DateEngine expirationDate) {
        this.source = Objects.requireNonNull(source);
        this.status = Objects.requireNonNull(status);
        this.createdOn = Objects.requireNonNull(createdOn);
        this.token = Objects.requireNonNull(token);
        this.expirationDate = Objects.requireNonNull(expirationDate);
    }

    public Transaction copyWith(UniqueId id, String source, TransactionStatus status, DateEngine createdOn, String token, DateEngine expirationDate){
        return new Transaction(
                source != null ? source : this.source,
                status != null ? status : this.status,
                createdOn != null ? createdOn : this.createdOn,
                token != null ? token : this.token,
                expirationDate != null ? expirationDate : this.expirationDate
        );
    }

    public UniqueId getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public DateEngine getCreatedOn() {
        return createdOn;
    }

    public void setId(UniqueId id) {
        this.id = Objects.requireNonNull(id);
    }

    private UniqueId id;

    private final String source;
    private final TransactionStatus status;
    private final DateEngine createdOn;

    private String token;
    private DateEngine expirationDate;
}
