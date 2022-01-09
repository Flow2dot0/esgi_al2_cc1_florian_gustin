package com.amazen.membership.domain;

public final class InvalidFullNameException extends RuntimeException {
    private InvalidFullNameException(String message) {
        super(message);
    }

    public static InvalidFullNameException from(String firstname, String lastname){
        return new InvalidFullNameException(String.format("Invalid name format with value : %s %s", firstname, lastname));
    }
}
