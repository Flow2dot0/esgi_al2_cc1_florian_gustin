package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;

public final class CityValidator implements ValidatorEngine<String> {
    public static final CityValidator INSTANCE = new CityValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
