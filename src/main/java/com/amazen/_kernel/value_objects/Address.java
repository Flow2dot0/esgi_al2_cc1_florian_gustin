package com.amazen._kernel.value_objects;

import com.amazen._kernel.abstracts.ValueObject;
import com.amazen._kernel.exceptions.InvalidAddressException;
import com.amazen._membership.domain.City;

import java.util.Objects;


public class Address implements ValueObject {
    private final String address;
    private final City city;

    private Address(String address, City city) {
        Objects.requireNonNull(address);
        Objects.requireNonNull(city);
        // stub
        if(address.equals(city.getValue()))
            throw InvalidAddressException.from(address, city);
        this.address = address;
        this.city = city;
    }

    static Address of(String address, City city){
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
