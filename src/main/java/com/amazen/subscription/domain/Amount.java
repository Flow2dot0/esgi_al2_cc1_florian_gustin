package com.amazen.subscription.domain;

import com.amazen.kernel.ValueObject;

import java.util.Currency;
import java.util.Objects;

public class Amount implements ValueObject {
    private final int value;
    private final Currency currency;

    private Amount(int value, Currency currency) {
        this.value = value;
        this.currency = Objects.requireNonNull(currency);
    }

    static Amount of(int value, Currency currency) {
        return new Amount(value, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value && Objects.equals(currency, amount.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
