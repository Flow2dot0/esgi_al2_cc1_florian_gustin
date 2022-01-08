package com.amazen.membership.domain.cc2;

public final class InvalidPasswordException extends RuntimeException {
    private InvalidPasswordException(String message) {
        super(message);
    }

    public static InvalidPasswordException from(String password){
        return new InvalidPasswordException(String.format("Invalid password format with value : %s", password));
    }
}
