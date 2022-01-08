package com.amazen.kernel;

import java.util.Collection;

public interface Repository<A, B> {
    B findById(A a);
    Collection<B> findAll();
    B save(B b);
    void delete(A a);
}
