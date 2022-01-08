package com.amazen.membership.domain.cc2;

public enum Skill {
    MASON("mason"),
    PLUMBER("plumber");

    final private String value;

    Skill(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
