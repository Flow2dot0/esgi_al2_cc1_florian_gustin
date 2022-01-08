package com.amazen.kernel.engines;


import com.amazen.kernel.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class InMemoryRepositoryEngine<A, B> implements Repository<A, B> {
    protected final AtomicInteger count;
    protected final Map<A, B> data;

    protected InMemoryRepositoryEngine() {
        count = new AtomicInteger(0);
        data = new ConcurrentHashMap<>();
    }

    public abstract A nextId();

    @Override
    public void delete(A a) {
        data.remove(a);
    }

    @Override
    public B findById(A a){
        return data.get(a);
    }

    @Override
    public Collection<B> findAll() {
        return data.values();
    }
}
