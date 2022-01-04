package com.amazen._core.interfaces;

public interface ValidatorEngine<T> {
    boolean test(T candidate);

}
