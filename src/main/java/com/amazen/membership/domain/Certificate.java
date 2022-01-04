package com.amazen.membership.domain;

import com.amazen.kernel.abstracts.ValueObject;

import java.util.Objects;

final class Certificate implements ValueObject {

    private final int code;
    private final Skill skill;
    private final String source;

    private Certificate(int code, Skill skill, String source) {
        this.code = code;
        this.skill = Objects.requireNonNull(skill);
        this.source = Objects.requireNonNull(source);
    }

    public static Certificate of(int code, Skill skill, String source){
        return new Certificate(code, skill, source);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return code == that.code && skill == that.skill && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, skill, source);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "code=" + code +
                ", skill=" + skill +
                ", source='" + source + '\'' +
                '}';
    }
}
