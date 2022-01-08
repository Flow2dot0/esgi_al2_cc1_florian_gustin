package com.amazen.membership.domain.cc2;

import com.amazen._kernel.abstracts.Entity;
import com.amazen._kernel.value_objects.Email;
import com.amazen.kernel.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Company implements Entity<CompanyID> {
    private final CompanyID id;
    private final String name;
    private final Address address;

    public Company(CompanyID id, String name, Address address) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);
    }

    @Override
    public CompanyID getId() {
        return id;
    }

    @Override
    public void setId(CompanyID companyID) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
