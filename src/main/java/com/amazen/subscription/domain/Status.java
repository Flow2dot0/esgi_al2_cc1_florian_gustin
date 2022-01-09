package com.amazen.subscription.domain;

public enum Status {
    SUCCESS("success"),
    FAIL("fail");

    final private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
