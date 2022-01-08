package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public class CardNumberValidator implements ValidatorEngine<Long> {
    public static final CardNumberValidator INSTANCE = new CardNumberValidator();
    @Override
    public boolean test(Long candidate) {
        return candidate.toString().length() == 16;
    }
}
