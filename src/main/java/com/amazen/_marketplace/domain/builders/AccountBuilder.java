package com.amazen._marketplace.domain.builders;

import com.amazen._marketplace.domain.entities.Account;
import com.amazen._marketplace.domain.entities.AccountType;
import com.amazen._core.exceptions.ExceptionUtils;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._marketplace.domain.interfaces.AccountBuilderEngine;
import com.amazen._core.value_objects.ValueObjectAbstract;
import com.amazen._core.value_objects.ValueObjectFactory;

public class AccountBuilder implements AccountBuilderEngine {

    private String email;
    private String password;

    private String firstname;
    private String lastname;

    private String address;
    private Integer zipcode;
    private String city;
    private String country;

    private String company;
    private String siret;

    private AccountType accountType;

    private Account account;


    @Override
    public AccountBuilderEngine withEmail(String email) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withEmailValidator(email);
        if(valueObject.isValid()){
            this.email = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.EMAIL);
    }

    @Override
    public AccountBuilderEngine withPassword(String password) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withPasswordValidator(password);
        if(valueObject.isValid()){
            this.password = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.PASSWORD);
    }

    @Override
    public AccountBuilderEngine withFirstname(String firstname) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withFirstnameValidator(firstname);
        if(valueObject.isValid()){
            this.firstname = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.FIRSTNAME);
    }

    @Override
    public AccountBuilderEngine withLastname(String lastname) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withLastnameValidator(lastname);
        if(valueObject.isValid()){
            this.lastname = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.LASTNAME);
    }

    @Override
    public AccountBuilderEngine withAddress(String address) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withAddressValidator(address);
        if(valueObject.isValid()){
            this.address = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.ADDRESS);
    }

    @Override
    public AccountBuilderEngine withZipcode(int zipcode) throws ValueObjectException {
        ValueObjectAbstract<Integer> valueObject = ValueObjectFactory.withZipcodeValidator(zipcode);
        if(valueObject.isValid()){
            this.zipcode = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.ZIPCODE);
    }

    @Override
    public AccountBuilderEngine withCity(String city) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withCityValidator(city);
        if(valueObject.isValid()){
            this.city = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.CITY);
    }

    @Override
    public AccountBuilderEngine withCountry(String country) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withCountryValidator(country);
        if(valueObject.isValid()){
            this.country = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.COUNTRY);
    }

    @Override
    public AccountBuilderEngine withCompany(String company) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withCompanyValidator(company);
        if(valueObject.isValid()){
            this.company = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.COMPANY);
    }

    @Override
    public AccountBuilderEngine withSiret(String siret) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withSiretValidator(siret);
        if(valueObject.isValid()){
            this.siret = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.SIRET);
    }



    @Override
    public AccountBuilderEngine withAccountType(AccountType accountType) throws ValueObjectException {
        this.accountType = accountType;
        return this;
    }


    @Override
    public Account build() {
        account = new Account(email,
                password,
                firstname,
                lastname,
                address,
                zipcode,
                city,
                country,
                company,
                siret,
                accountType);
        return account;
    }
}
