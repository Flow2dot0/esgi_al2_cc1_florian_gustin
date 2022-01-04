package com.amazen._multipay.domain.factories;

import com.amazen._core.LocalDate;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._multipay.domain.builders.BankInformationBuilder;
import com.amazen._multipay.domain.entities.BankInformation;

public final class BankInformationFactory {
    private BankInformationFactory() {
        throw new AssertionError();
    }

    public static BankInformation stubValidBankInformation() throws ValueObjectException {
        return new BankInformationBuilder()
                .withCardNumber(1234123412341234L)
                .withCardSecurityCode(123)
                .withExpirationDate(new LocalDate(2023, 10, 10))
                .withFirstname("bill")
                .withLastname("gates")
                .build();
    }
}
