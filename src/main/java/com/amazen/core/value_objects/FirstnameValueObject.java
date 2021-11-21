package com.amazen.core.value_objects;


import com.amazen.core.interfaces.ValidatorEngine;
import org.apache.commons.text.StringEscapeUtils;

public class FirstnameValueObject extends ValueObjectAbstract<String> {

    public FirstnameValueObject(ValidatorEngine<String> validator, String value) {
        super(validator, StringEscapeUtils.escapeHtml4(value));
    }
}
