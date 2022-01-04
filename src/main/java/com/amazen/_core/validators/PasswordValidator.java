package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;

public final class PasswordValidator implements ValidatorEngine<String> {

    public static final PasswordValidator INSTANCE = new PasswordValidator();

    @Override
    public boolean test(String candidate) {
        return candidate.length() >= 6;
    }
}
