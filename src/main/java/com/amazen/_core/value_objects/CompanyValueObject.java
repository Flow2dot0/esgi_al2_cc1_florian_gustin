package com.amazen._core.value_objects;

import com.amazen._core.interfaces.ValidatorEngine;
import org.apache.commons.text.StringEscapeUtils;

public class CompanyValueObject extends ValueObjectAbstract<String> {
    public CompanyValueObject(ValidatorEngine<String> validator, String value) {
        super(validator, StringEscapeUtils.escapeHtml4(value));
    }
}
