package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.ValueObjectId;

import java.util.Objects;

public class ContractorId implements ValueObjectId<Integer> {
    private final Integer id;

    private ContractorId(int id) {
        this.id = id;
    }

    public static ContractorId of(int id){
        return new ContractorId(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorId contractorId = (ContractorId) o;
        return Objects.equals(id, contractorId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContractorId{" +
                "id=" + id +
                '}';
    }
}
