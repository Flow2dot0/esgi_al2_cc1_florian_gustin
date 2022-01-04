package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;

public final class ZipcodeValidator implements ValidatorEngine<Integer> {
    public static final ZipcodeValidator INSTANCE = new ZipcodeValidator();

    @Override
    public boolean test(Integer candidate) {
        return candidate.toString().length() == 5;
    }
}
