package com.amazen._membership.domain;

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
