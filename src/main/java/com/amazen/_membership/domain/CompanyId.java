package com.amazen._membership.domain;

import com.amazen._kernel.abstracts.ValueObjectId;

import java.util.Objects;

public class CompanyId implements ValueObjectId<Integer> {
    private final Integer id;

    private CompanyId(int id) {
        this.id = id;
    }

    static CompanyId of(int id){
        return new CompanyId(id);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyId companyId = (CompanyId) o;
        return Objects.equals(id, companyId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CompanyId{" +
                "id=" + id +
                '}';
    }
}
