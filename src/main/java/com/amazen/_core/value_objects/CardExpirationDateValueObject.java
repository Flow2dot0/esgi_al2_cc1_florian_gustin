package com.amazen._core.value_objects;

import com.amazen._core.interfaces.DateEngine;
import com.amazen._core.interfaces.ValidatorEngine;

public class CardExpirationDateValueObject extends ValueObjectAbstract<DateEngine> {

    public CardExpirationDateValueObject(ValidatorEngine<DateEngine> validator, DateEngine value) {
        super(validator, value);
    }
}
