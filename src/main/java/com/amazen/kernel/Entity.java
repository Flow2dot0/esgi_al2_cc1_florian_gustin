package com.amazen.kernel;

import java.util.List;

public interface Entity<T> {
    T getId();
    void setId(T t);
}
