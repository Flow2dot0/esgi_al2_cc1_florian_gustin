package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class CompanyValidator implements ValidatorEngine<String> {
    public static final CompanyValidator INSTANCE = new CompanyValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
