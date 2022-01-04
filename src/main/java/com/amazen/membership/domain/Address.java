package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.ValueObject;
import com.amazen.membership.domain.exception.InvalidAddressException;

import java.util.Objects;

final class Address implements ValueObject {
    private final String address;
    private final String city;

    private Address(String address, String city) {
        Objects.requireNonNull(address);
        Objects.requireNonNull(city);
        // stub
        if(address.equals(city))
            throw InvalidAddressException.from(address, city);
        this.address = address;
        this.city = city;
    }

    static Address of(String address, String city){
        return new Address(address, city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(address, address1.address) && Objects.equals(city, address1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
