package com.amazen.kernel.engines;

import com.amazen.kernel.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class InMemoryRepositoryEngine<ID, EN, EV> implements Repository<ID, EN, EV> {
    protected final AtomicInteger count;
    protected final Map<ID, EV> data;

    protected InMemoryRepositoryEngine() {
        count = new AtomicInteger(0);
        data = new ConcurrentHashMap<>();
    }

    @Override
    public void delete(ID id) {
        data.remove(id);
    }
}
