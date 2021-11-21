package com.amazen.core.validators;

import com.amazen.core.interfaces.ValidatorEngine;

import java.util.regex.Pattern;

public final class EmailValidator implements ValidatorEngine<String> {

    public static final EmailValidator INSTANCE = new EmailValidator();

    @Override
    public boolean test(String candidate) {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(candidate).find();
    }
}
