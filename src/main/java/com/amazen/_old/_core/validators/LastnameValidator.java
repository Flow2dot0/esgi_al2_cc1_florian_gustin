package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class LastnameValidator implements ValidatorEngine<String> {
    public static final LastnameValidator INSTANCE = new LastnameValidator();

    @Override
    public boolean test(String candidate) {
        return !candidate.isEmpty();
    }
}
