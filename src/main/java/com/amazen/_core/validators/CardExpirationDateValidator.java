package com.amazen._core.validators;

import com.amazen._core.interfaces.ValidatorEngine;
import com.amazen._core.interfaces.DateEngine;

public class CardExpirationDateValidator implements ValidatorEngine<DateEngine> {
    public static final CardExpirationDateValidator INSTANCE = new CardExpirationDateValidator();
    @Override
    public boolean test(DateEngine candidate) {
        return candidate.isAfterNow();
    }
}
