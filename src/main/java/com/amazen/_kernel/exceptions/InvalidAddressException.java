package com.amazen._kernel.exceptions;

import com.amazen._membership.domain.City;

public final class InvalidAddressException extends RuntimeException {
    private InvalidAddressException(String message) {
        super(message);
    }

    public static InvalidAddressException from(String address, City city){
        return new InvalidAddressException(String.format("Invalid address and city : %s %s", address, city.getValue()));
    }
}
