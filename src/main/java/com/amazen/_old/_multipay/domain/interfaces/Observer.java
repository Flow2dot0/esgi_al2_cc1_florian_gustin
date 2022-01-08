package com.amazen._old._multipay.domain.interfaces;

import com.amazen._old._core.annotations.Contract;
import com.amazen._old._multipay.domain.entities.Transaction;

@Contract
public interface Observer {
    void update(Transaction transaction);
}
