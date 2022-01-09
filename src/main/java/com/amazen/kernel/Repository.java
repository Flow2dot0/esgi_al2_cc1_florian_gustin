package com.amazen.kernel;

import java.util.Collection;

public interface Repository<ID, EN, EV> {
    ID nextID();
    EN findById(ID id);
    Collection<EN> findAll();
    EN save(EN entity);
    void delete(ID id);
}
