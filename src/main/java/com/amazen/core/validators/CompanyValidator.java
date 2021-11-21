package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;

public final class CompanyValidator implements ValidatorEngine<String> {
    public static final CompanyValidator INSTANCE = new CompanyValidator();

    @Override
    public boolean test(String candidate) {
        return true;
    }
}
