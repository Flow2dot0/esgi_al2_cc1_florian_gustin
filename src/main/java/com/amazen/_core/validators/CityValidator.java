package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;

public final class CityValidator implements ValidatorEngine<String> {
    public static final CityValidator INSTANCE = new CityValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
