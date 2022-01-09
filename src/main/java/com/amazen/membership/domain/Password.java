package com.amazen.membership.domain;

import com.amazen.kernel.ValueObject;

import java.util.Objects;

public final class Password implements ValueObject {
    private final String combination;

    private Password(String combination) {
        Objects.requireNonNull(combination);
        if(combination.length() < 6)
            throw InvalidPasswordException.from(combination);
        this.combination = combination;
    }

    public static Password of(String combination){
        return new Password(combination);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(combination, password.combination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(combination);
    }

    @Override
    public String toString() {
        return "Password{" +
                "combination='" + combination + '\'' +
                '}';
    }
}
