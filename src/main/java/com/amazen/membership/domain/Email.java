package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.ValueObject;
import com.amazen.membership.domain.exception.InvalidEmailException;

import java.util.Objects;
import java.util.regex.Pattern;

final class Email implements ValueObject {
    private final String address;

    private Email(String email) {
        Objects.requireNonNull(email);
        if(!Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).find())
            throw InvalidEmailException.from(email);
        this.address = Objects.requireNonNull(email);
    }

    public static Email of(String email){
        return new Email(email);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                '}';
    }
}
