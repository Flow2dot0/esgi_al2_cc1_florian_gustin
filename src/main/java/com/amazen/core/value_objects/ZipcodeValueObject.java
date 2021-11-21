package com.amazen.core.value_objects;

import com.amazen.core.interfaces.ValidatorEngine;

public class ZipcodeValueObject extends ValueObjectAbstract<Integer> {
    public ZipcodeValueObject(ValidatorEngine<Integer> validator, Integer value) {
        super(validator, value);
    }
}
