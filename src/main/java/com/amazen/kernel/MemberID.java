package com.amazen.kernel;

import java.util.Objects;

public class MemberID implements ValueObjectId<Integer> {

    private final Integer id;

    public MemberID(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberID memberID = (MemberID) o;
        return Objects.equals(id, memberID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberID{" +
                "id=" + id +
                '}';
    }
}
