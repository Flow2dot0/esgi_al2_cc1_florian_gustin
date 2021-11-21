package com.amazen.marketplace.domain.interfaces;

import com.amazen.marketplace.domain.entities.Account;
import com.amazen.marketplace.domain.entities.AccountType;
import com.amazen.core.exceptions.ValueObjectException;


public interface AccountBuilderEngine {

    AccountBuilderEngine withEmail(String email) throws ValueObjectException;
    AccountBuilderEngine withPassword(String password) throws ValueObjectException;
    AccountBuilderEngine withFirstname(String firstname) throws ValueObjectException;
    AccountBuilderEngine withLastname(String lastname) throws ValueObjectException;
    AccountBuilderEngine withAddress(String address) throws ValueObjectException;
    AccountBuilderEngine withZipcode(int zipcode) throws ValueObjectException;
    AccountBuilderEngine withCity(String city) throws ValueObjectException;
    AccountBuilderEngine withCountry(String country) throws ValueObjectException;
    AccountBuilderEngine withCompany(String company) throws ValueObjectException;
    AccountBuilderEngine withSiret(String siret) throws ValueObjectException;
    AccountBuilderEngine withAccountType(AccountType accountType) throws ValueObjectException;

    Account build();

}

