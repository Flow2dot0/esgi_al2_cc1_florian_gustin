package com.amazen.marketplace.domain.interfaces;

import com.amazen.core.annotations.Contract;
import com.amazen.core.exceptions.ValueObjectException;

@Contract
public interface Repository<T> {
    T save(T t) throws ValueObjectException;
    void delete(T t);
}
