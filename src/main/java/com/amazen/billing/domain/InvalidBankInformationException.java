package com.amazen.billing.domain;

public final class InvalidBankInformationException extends RuntimeException {
    private InvalidBankInformationException(String message) {
        super(message);
    }

    public static InvalidBankInformationException from(Bank bank){
        return new InvalidBankInformationException(String.format("Invalid name format with value : %s", bank));
    }
}
