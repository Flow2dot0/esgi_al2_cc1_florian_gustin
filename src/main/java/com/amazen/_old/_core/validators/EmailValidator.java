package com.amazen._old._core.validators;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class EmailValidator implements Predicate<String> {

    public static final EmailValidator INSTANCE = new EmailValidator();

    @Override
    public boolean test(String candidate) {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(candidate).find();
    }
}
