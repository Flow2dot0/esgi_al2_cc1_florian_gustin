package com.amazen._subscription;

import com.amazen._kernel.abstracts.ValueObjectId;

import java.util.Objects;

public class SubscriptionId implements ValueObjectId<Integer> {
    private final Integer id;

    private SubscriptionId(int id) {
        this.id = id;
    }

    public static SubscriptionId of(int id){
        return new SubscriptionId(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionId subscriptionId = (SubscriptionId) o;
        return Objects.equals(id, subscriptionId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubscriptionId{" +
                "id=" + id +
                '}';
    }
}
