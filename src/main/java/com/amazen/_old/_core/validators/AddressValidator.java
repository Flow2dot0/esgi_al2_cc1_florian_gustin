package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class AddressValidator implements ValidatorEngine<String> {
    public static final AddressValidator INSTANCE = new AddressValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
