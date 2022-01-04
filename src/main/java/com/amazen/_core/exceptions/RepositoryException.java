package com.amazen._core.exceptions;

import java.util.Objects;

public class RepositoryException extends Exception {
    protected RepositoryException(String message) {
        super(Objects.requireNonNull(message));
    }

    public static RepositoryException createMessage(String message){
        return new RepositoryException(message);
    }
}
