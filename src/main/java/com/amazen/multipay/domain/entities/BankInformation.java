package com.amazen.multipay.domain.entities;

import com.amazen.core.interfaces.DateEngine;

import java.util.Objects;

public class BankInformation {

    public BankInformation(Long cardNumber, Integer cardSecurityCode, DateEngine expirationDate, String firstname, String lastname) {
        this.cardNumber = Objects.requireNonNull(cardNumber);
        this.cardSecurityCode = Objects.requireNonNull(cardSecurityCode);
        this.expirationDate = Objects.requireNonNull(expirationDate);
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
    }

    private final Long cardNumber;
    private final Integer cardSecurityCode;
    private final DateEngine expirationDate;

    private final String firstname;
    private final String lastname;

}
