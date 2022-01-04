package com.amazen._marketplace.domain.entities;

import com.amazen._core.entities.UniqueId;
import com.amazen._core.interfaces.DateEngine;

import java.util.Objects;

public class Account {

    private final String email;
    private final String password;

    private final String firstname;
    private final String lastname;

    private final String address;
    private final Integer zipcode;
    private final String city;
    private final String country;

    private final String company;
    private final String siret;

    private final AccountType accountType;

    public DateEngine getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateEngine createdOn) {
        this.createdOn = Objects.requireNonNull(createdOn);
    }

    private DateEngine createdOn;

    private UniqueId id;

    public UniqueId getId() {
        return id;
    }

    public void setId(UniqueId id) {
        this.id = Objects.requireNonNull(id);
    }

    public Account(String email, String password, String firstname, String lastname, String address, Integer zipcode, String city, String country, String company, String siret, AccountType accountType) {
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.address = Objects.requireNonNull(address);
        this.zipcode = Objects.requireNonNull(zipcode);
        this.city = Objects.requireNonNull(city);
        this.country = Objects.requireNonNull(country);
        this.company = Objects.requireNonNull(company);
        this.siret = Objects.requireNonNull(siret);
        this.accountType = Objects.requireNonNull(accountType);
    }


}