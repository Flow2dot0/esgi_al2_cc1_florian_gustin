package com.amazen._kernel.exceptions;

public final class InvalidNameException extends RuntimeException {
    private InvalidNameException(String message) {
        super(message);
    }

    public static InvalidNameException from(String firstname, String lastname){
        return new InvalidNameException(String.format("Invalid name format with value : %s %s", firstname, lastname));
    }
}
