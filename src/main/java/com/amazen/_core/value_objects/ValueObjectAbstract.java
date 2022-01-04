package com.amazen._core.value_objects;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._core.interfaces.ValidatorEngine;

import java.util.Objects;

public abstract class ValueObjectAbstract<T> {

    private final ValidatorEngine<T> validator;
    private final T value;

    public ValueObjectAbstract(ValidatorEngine<T> validator, T value) {
        this.validator = Objects.requireNonNull(validator);
        this.value = Objects.requireNonNull(value);
    }

    public boolean isValid() {
        return validator.test(value);
    }

    public T get() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        T t = (T) obj;
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"{" +
                "value=" + value +
                '}';
    }

    public ValueObjectException createException(String message) {
        return ValueObjectException.createMessage(message);
    }
}