package com.amazen._old._multipay.domain.interfaces;

import com.amazen._old._core.annotations.Contract;

@Contract
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyListener();
}
