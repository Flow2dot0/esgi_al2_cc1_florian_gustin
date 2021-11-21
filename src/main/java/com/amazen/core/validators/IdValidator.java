package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;

public final class IdValidator implements ValidatorEngine<Integer> {
    public static final IdValidator INSTANCE = new IdValidator();

    @Override
    public boolean test(Integer candidate) {
        return true;
    }
}
