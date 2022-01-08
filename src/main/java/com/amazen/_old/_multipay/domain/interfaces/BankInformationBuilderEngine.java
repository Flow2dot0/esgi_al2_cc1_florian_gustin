package com.amazen._old._multipay.domain.interfaces;

import com.amazen._old._core.interfaces.DateEngine;
import com.amazen._old._core.exceptions.ValueObjectException;
import com.amazen._old._multipay.domain.entities.BankInformation;

public interface BankInformationBuilderEngine {

   BankInformationBuilderEngine withCardNumber(long cardNumber) throws ValueObjectException;
   BankInformationBuilderEngine withCardSecurityCode(int cardSecurityCode) throws ValueObjectException;
   BankInformationBuilderEngine withExpirationDate(DateEngine expirationDate) throws ValueObjectException;
   BankInformationBuilderEngine withFirstname(String firstname) throws ValueObjectException;
   BankInformationBuilderEngine withLastname(String lastname) throws ValueObjectException;

   BankInformation build();
}
