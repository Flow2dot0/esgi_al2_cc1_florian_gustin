package com.amazen._old._core.validators;

import com.amazen._old._core.interfaces.ValidatorEngine;
import com.amazen._old._core.interfaces.DateEngine;

public class CardExpirationDateValidator implements ValidatorEngine<DateEngine> {
    public static final CardExpirationDateValidator INSTANCE = new CardExpirationDateValidator();
    @Override
    public boolean test(DateEngine candidate) {
        return candidate.isAfterNow();
    }
}
