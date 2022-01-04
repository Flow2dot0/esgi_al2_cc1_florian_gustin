package com.amazen._marketplace.domain.interfaces;

import com.amazen._core.annotations.Contract;
import com.amazen._core.exceptions.ValueObjectException;

@Contract
public interface Repository<T> {
    T save(T t);
    void delete(T t);
}
