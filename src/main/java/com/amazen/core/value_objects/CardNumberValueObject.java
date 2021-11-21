package com.amazen.core.value_objects;

import com.amazen.core.interfaces.ValidatorEngine;

public class CardNumberValueObject extends ValueObjectAbstract<Long> {
    public CardNumberValueObject(ValidatorEngine<Long> validator, Long value) {
        super(validator, value);
    }
}
