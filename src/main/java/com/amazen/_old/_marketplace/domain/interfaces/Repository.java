package com.amazen._old._marketplace.domain.interfaces;

import com.amazen._old._core.annotations.Contract;

import java.util.Collection;

@Contract
public interface Repository<T> {
    T findById(int id);
    Collection<T> findAll();
    T save(T t);
    void delete(T t);
}
