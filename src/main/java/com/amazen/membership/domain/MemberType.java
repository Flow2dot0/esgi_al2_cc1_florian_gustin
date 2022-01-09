package com.amazen.membership.domain;

public enum MemberType {
    CONTRACTOR("contractor"),
    TRADESMAN("tradesman");

    final private String value;

    MemberType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
