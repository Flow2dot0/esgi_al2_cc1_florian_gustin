package com.amazen.subscription.domain;



import com.amazen.kernel.ValueObjectId;

import java.util.Objects;

public class TransactionID implements ValueObjectId<Integer> {
    private final Integer id;

    private TransactionID(int id) {
        this.id = id;
    }

    public static TransactionID of(int id){
        return new TransactionID(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionID transactionId = (TransactionID) o;
        return Objects.equals(id, transactionId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TransactionId{" +
                "id=" + id +
                '}';
    }
}
