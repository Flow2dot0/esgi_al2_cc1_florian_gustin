package com.amazen.core.value_objects;

import com.amazen.core.interfaces.ValidatorEngine;

public class CardSecurityCodeValueObject extends ValueObjectAbstract<Integer> {
    public CardSecurityCodeValueObject(ValidatorEngine<Integer> validator, Integer value) {
        super(validator, value);
    }
}
