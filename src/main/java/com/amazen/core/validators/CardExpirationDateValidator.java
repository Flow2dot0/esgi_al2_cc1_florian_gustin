package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;
import com.amazen.core.interfaces.DateEngine;

public class CardExpirationDateValidator implements ValidatorEngine<DateEngine> {
    public static final CardExpirationDateValidator INSTANCE = new CardExpirationDateValidator();
    @Override
    public boolean test(DateEngine candidate) {
        return candidate.isAfterNow();
    }
}
