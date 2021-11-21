package com.amazen.multipay.domain.interfaces;

import com.amazen.core.annotations.Contract;

@Contract
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyListener();
}
