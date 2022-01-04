package com.amazen._core.value_objects;

import com.amazen._core.interfaces.ValidatorEngine;

public class ZipcodeValueObject extends ValueObjectAbstract<Integer> {
    public ZipcodeValueObject(ValidatorEngine<Integer> validator, Integer value) {
        super(validator, value);
    }
}
