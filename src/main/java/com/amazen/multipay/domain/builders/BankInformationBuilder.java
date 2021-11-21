package com.amazen.multipay.domain.builders;

import com.amazen.core.interfaces.DateEngine;
import com.amazen.core.exceptions.ExceptionUtils;
import com.amazen.core.exceptions.ValueObjectException;
import com.amazen.core.value_objects.ValueObjectAbstract;
import com.amazen.core.value_objects.ValueObjectFactory;
import com.amazen.multipay.domain.entities.BankInformation;
import com.amazen.multipay.domain.interfaces.BankInformationBuilderEngine;

public class BankInformationBuilder implements BankInformationBuilderEngine {

    private Long cardNumber;
    private Integer cardSecurityCode;
    private DateEngine expirationDate;

    private String firstname;
    private String lastname;

    private BankInformation bankInformation;


    @Override
    public BankInformationBuilderEngine withCardNumber(long cardNumber) throws ValueObjectException {
        ValueObjectAbstract<Long> valueObject = ValueObjectFactory.withCardNumberValidator(cardNumber);
        if(valueObject.isValid()){
            this.cardNumber = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.CARD_NUMBER);
    }

    @Override
    public BankInformationBuilderEngine withCardSecurityCode(int cardSecurityCode) throws ValueObjectException {
        ValueObjectAbstract<Integer> valueObject = ValueObjectFactory.withCardSecurityCodeValidator(cardSecurityCode);
        if(valueObject.isValid()){
            this.cardSecurityCode = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.CARD_SECURITY_CODE);
    }

    @Override
    public BankInformationBuilderEngine withExpirationDate(DateEngine expirationDate) throws ValueObjectException {
        ValueObjectAbstract<DateEngine> valueObject = ValueObjectFactory.withCardExpirationDateValidator(expirationDate);
        if(valueObject.isValid()){
            this.expirationDate = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.CARD_EXPIRATION_DATE);
    }

    @Override
    public BankInformationBuilderEngine withFirstname(String firstname) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withFirstnameValidator(firstname);
        if(valueObject.isValid()){
            this.firstname = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.FIRSTNAME);
    }

    @Override
    public BankInformationBuilderEngine withLastname(String lastname) throws ValueObjectException {
        ValueObjectAbstract<String> valueObject = ValueObjectFactory.withLastnameValidator(lastname);
        if(valueObject.isValid()){
            this.lastname = valueObject.get();
            return this;
        }
        throw valueObject.createException(ExceptionUtils.LASTNAME);
    }

    @Override
    public BankInformation build() {
        bankInformation = new BankInformation(cardNumber, cardSecurityCode, expirationDate, firstname, lastname);
        return bankInformation;
    }
}
