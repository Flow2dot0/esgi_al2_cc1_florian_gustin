package com.amazen.kernel.exceptions;

import java.util.Currency;

public final class InvalidAmountException extends RuntimeException {
    private InvalidAmountException(String message) {
        super(message);
    }

    public static InvalidAmountException from(int value, Currency currency){
        return new InvalidAmountException(String.format("Invalid amount with values : %s %s", value, currency.getCurrencyCode()));
    }
}
