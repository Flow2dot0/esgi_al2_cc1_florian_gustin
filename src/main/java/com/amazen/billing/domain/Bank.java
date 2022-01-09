package com.amazen.billing.domain;

import com.amazen.kernel.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class Bank implements ValueObject {
    private final long cardNumber;
    private final CardType cardType;
    private final LocalDate expirationDate;
    private final int secureCode;

    public Bank(long cardNumber, CardType cardType, LocalDate expirationDate, int secureCode) {
        if(String.valueOf(cardNumber).length() != 16 || expirationDate.isEqual(LocalDate.now()) || expirationDate.isBefore(LocalDate.now())){
            throw InvalidBankInformationException.from(this);
        }
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.secureCode = secureCode;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getSecureCode() {
        return secureCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return cardNumber == bank.cardNumber && secureCode == bank.secureCode && cardType == bank.cardType && Objects.equals(expirationDate, bank.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardType, expirationDate, secureCode);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "cardNumber=" + cardNumber +
                ", cardType=" + cardType +
                ", expirationDate=" + expirationDate +
                ", secureCode=" + secureCode +
                '}';
    }
}
