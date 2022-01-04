package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.Entity;

import java.util.Objects;

public class Company implements Entity<CompanyId> {
    private CompanyId id;
    private String name;
    private Address address;
    private Email email;

    private Company(CompanyId id, String name, Address address, Email email) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(address);
        Objects.requireNonNull(email);
        this.id = id;
        this.address = address;
        this.email = email;
    }

    static Company of(CompanyId id, String name, Address address, Email email){
        return new Company(id, name, address, email);
    }

    @Override
    public CompanyId getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setId(CompanyId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
