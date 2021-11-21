package com.amazen.core.entities;

import com.amazen.core.interfaces.UniqueIdObject;

public class NullUniqueId implements UniqueIdObject {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
