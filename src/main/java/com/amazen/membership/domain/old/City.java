package com.amazen.membership.domain.old;

public enum City {
    PARIS("Paris"),
    LEVALLOIS("Levallois"),
    NICE("Nice"),
    MONACO("Monaco"),
    TOULOUSE("Toulouse");


    final private String value;

    City(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
