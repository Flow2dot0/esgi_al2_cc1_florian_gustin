package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class SiretValidator implements ValidatorEngine<String> {
    public static final SiretValidator INSTANCE = new SiretValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
