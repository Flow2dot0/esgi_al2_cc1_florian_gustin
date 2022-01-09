package com.amazen.membership.domain;

public final class InvalidEmailException extends RuntimeException {
    private InvalidEmailException(String message) {
        super(message);
    }

    public static InvalidEmailException from(String address){
        return new InvalidEmailException(String.format("Invalid email format with value : %s", address));
    }
}
