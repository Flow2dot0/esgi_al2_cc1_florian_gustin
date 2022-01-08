package com.amazen._old._marketplace.domain.interfaces;

import com.amazen._old._core.exceptions.ValueObjectException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class InMemoryRepositoryEngine<A, B> implements Repository<B> {
    protected final AtomicInteger count;
    protected final Map<A, B> data;

    protected InMemoryRepositoryEngine() {
        count = new AtomicInteger(0);
        data = new ConcurrentHashMap<>();
    }

    protected abstract A nextId() throws ValueObjectException;
    public abstract B findById(A a);

}
