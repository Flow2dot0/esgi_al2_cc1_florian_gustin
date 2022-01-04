package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.Entity;

import java.util.Objects;

public class Company implements Entity<CompanyId> {
    private final CompanyId id;
    private final Address address;
    private final Email email;

    public Company(CompanyId id, Address address, Email email) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(address);
        Objects.requireNonNull(email);
        this.id = id;
        this.address = address;
        this.email = email;
    }

    static Company of(CompanyId id, Address address, Email email){
        return new Company(id, address, email);
    }

    @Override
    public CompanyId getId() {
        return id;
    }
}
