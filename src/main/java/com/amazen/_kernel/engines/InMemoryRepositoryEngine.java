//package com.amazen._kernel.engines;
//
//import com.amazen._kernel.abstracts.Repository;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public abstract class InMemoryRepositoryEngine<A, B> implements Repository<A, B> {
//    protected final AtomicInteger count;
//    protected final Map<A, B> data;
//
//    protected InMemoryRepositoryEngine() {
//        count = new AtomicInteger(0);
//        data = new ConcurrentHashMap<>();
//    }
//
//    protected abstract A nextId();
//    public void remove(A a) {
//        data.remove(a);
//    }
//    public B findById(A a){
//        return data.get(a);
//    }
//
//}
