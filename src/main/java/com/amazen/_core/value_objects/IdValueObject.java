package com.amazen._core.value_objects;

import com.amazen._core.interfaces.ValidatorEngine;

public class IdValueObject extends ValueObjectAbstract<Integer> {
    public IdValueObject(ValidatorEngine<Integer> validator, Integer value) {
        super(validator, value);
    }
}
