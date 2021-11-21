package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;

public final class LastnameValidator implements ValidatorEngine<String> {
    public static final LastnameValidator INSTANCE = new LastnameValidator();

    @Override
    public boolean test(String candidate) {
        return !candidate.isEmpty();
    }
}
