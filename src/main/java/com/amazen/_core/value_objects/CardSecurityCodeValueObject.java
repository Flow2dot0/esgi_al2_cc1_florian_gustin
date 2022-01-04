package com.amazen._core.value_objects;

import com.amazen._core.interfaces.ValidatorEngine;

public class CardSecurityCodeValueObject extends ValueObjectAbstract<Integer> {
    public CardSecurityCodeValueObject(ValidatorEngine<Integer> validator, Integer value) {
        super(validator, value);
    }
}
