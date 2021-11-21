package com.amazen.core.interfaces;

public interface ValidatorEngine<T> {
    boolean test(T candidate);

}
