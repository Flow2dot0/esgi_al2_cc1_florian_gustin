package com.amazen.core.value_objects;

import com.amazen.core.interfaces.DateEngine;
import com.amazen.core.interfaces.ValidatorEngine;

public class CardExpirationDateValueObject extends ValueObjectAbstract<DateEngine> {

    public CardExpirationDateValueObject(ValidatorEngine<DateEngine> validator, DateEngine value) {
        super(validator, value);
    }
}
