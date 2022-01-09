package com.amazen.membership.domain;

import com.amazen.kernel.ValueObject;

import java.util.Objects;

public class FullName implements ValueObject {
    private final String firstname;
    private final String lastname;

    private FullName(String firstname, String lastname) {
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);
        if(!firstname.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$") || !lastname.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$"))
            throw InvalidFullNameException.from(firstname, lastname);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static FullName of(String firstname, String lastname){
        return new FullName(firstname, lastname);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName name = (FullName) o;
        return Objects.equals(firstname, name.firstname) && Objects.equals(lastname, name.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
