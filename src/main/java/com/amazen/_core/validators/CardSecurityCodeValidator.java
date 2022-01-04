package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;

public class CardSecurityCodeValidator implements ValidatorEngine<Integer> {
    public static final CardSecurityCodeValidator INSTANCE = new CardSecurityCodeValidator();
    @Override
    public boolean test(Integer candidate) {
        return candidate.toString().length() == 3;
    }
}
