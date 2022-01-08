package com.amazen._kernel.abstracts;

import com.amazen.kernel.DomainEvent;

import java.util.List;

public interface Entity<T> {
    T getId();
    void setId(T t);
}
