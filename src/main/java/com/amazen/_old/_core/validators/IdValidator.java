package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;

public final class IdValidator implements ValidatorEngine<Integer> {
    public static final IdValidator INSTANCE = new IdValidator();

    @Override
    public boolean test(Integer candidate) {
        return true;
    }
}
