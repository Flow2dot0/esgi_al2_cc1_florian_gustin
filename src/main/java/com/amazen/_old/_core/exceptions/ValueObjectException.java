package com.amazen._old._core.exceptions;

import java.util.Objects;

public class ValueObjectException extends Exception {
    protected ValueObjectException(String message) {
        super(Objects.requireNonNull(message));
    }

    public static ValueObjectException createMessage(String message){
        return new ValueObjectException(message);
    }
}
