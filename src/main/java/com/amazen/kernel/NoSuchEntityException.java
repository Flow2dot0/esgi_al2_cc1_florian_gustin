package com.amazen.kernel;


public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ValueObjectId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getId()));
    }
}
