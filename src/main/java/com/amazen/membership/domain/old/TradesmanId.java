package com.amazen.membership.domain.old;

import com.amazen._kernel.abstracts.MemberId;

import java.util.Objects;

public class TradesmanId implements MemberId {
    private final Integer id;

    private TradesmanId(int id) {
        this.id = id;
    }

    public static TradesmanId of(int id){
        return new TradesmanId(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanId tradesmanId = (TradesmanId) o;
        return Objects.equals(id, tradesmanId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TradesmanId{" +
                "id=" + id +
                '}';
    }
}
