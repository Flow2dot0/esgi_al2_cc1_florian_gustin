package com.amazen._old._marketplace.domain.interfaces;

import com.amazen._old._core.exceptions.ValueObjectException;

import javax.naming.NoPermissionException;

public interface RegistrationService<T> {
    T findById(int id) throws ValueObjectException;
    T save(T t);
    void delete(T t) throws NoPermissionException;
}
