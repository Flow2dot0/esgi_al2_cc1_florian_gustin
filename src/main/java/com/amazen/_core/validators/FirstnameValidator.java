package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;

public final class FirstnameValidator implements ValidatorEngine<String> {
    public static final FirstnameValidator INSTANCE = new FirstnameValidator();

    @Override
    public boolean test(String candidate) {
        return candidate.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
    }
}
