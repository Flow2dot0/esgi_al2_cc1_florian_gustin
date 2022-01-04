package com.amazen._multipay.domain.interfaces;

import com.amazen._core.annotations.Contract;

@Contract
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyListener();
}
