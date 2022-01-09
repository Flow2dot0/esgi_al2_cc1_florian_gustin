package com.amazen.membership.domain;


import com.amazen.kernel.ValueObjectId;

import java.util.Objects;

public class CompanyID implements ValueObjectId<String> {
    private final String id;

    private CompanyID(String id) {
        this.id = id;
    }

    public static CompanyID of(String id){
        return new CompanyID(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyID companyId = (CompanyID) o;
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
