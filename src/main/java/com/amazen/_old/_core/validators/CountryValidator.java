package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class CountryValidator implements ValidatorEngine<String> {
    public static final CountryValidator INSTANCE = new CountryValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
