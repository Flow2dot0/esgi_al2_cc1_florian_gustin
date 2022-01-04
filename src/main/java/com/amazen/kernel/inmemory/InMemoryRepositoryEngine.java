package com.amazen.kernel.inmemory;

import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._marketplace.domain.interfaces.Repository;

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

    protected abstract A nextId();
    public abstract B findById(A a);

}
