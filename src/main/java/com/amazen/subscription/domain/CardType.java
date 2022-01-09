package com.amazen.subscription.domain;


public enum CardType {
    VISA("visa"),
    MASTERCARD("mastercard");

    final private String value;

    CardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
