package com.amazen.membership.domain.old;

import com.amazen._kernel.abstracts.ValueObjectId;

import java.util.Objects;

public class TransactionId implements ValueObjectId<Integer> {
    private final Integer id;

    private TransactionId(int id) {
        this.id = id;
    }

    static TransactionId of(int id){
        return new TransactionId(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId transactionId = (TransactionId) o;
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
