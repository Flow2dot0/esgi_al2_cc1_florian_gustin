package com.amazen._kernel.value_objects;

import com.amazen._kernel.abstracts.ValueObject;
import com.amazen._kernel.exceptions.InvalidNameException;

import java.util.Objects;

public class Name implements ValueObject {
    private final String firstname;
    private final String lastname;

    private Name(String firstname, String lastname) {
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);
        if(firstname.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$") || lastname.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$"))
            throw InvalidNameException.from(firstname, lastname);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Name of(String firstname, String lastname){
        return new Name(firstname, lastname);
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
        Name name = (Name) o;
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
