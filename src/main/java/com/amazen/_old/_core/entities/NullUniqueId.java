package com.amazen._old._core.entities;

import com.amazen._old._core.interfaces.ValueObjectId;

public class NullUniqueId implements ValueObjectId {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}
