package com.amazen._multipay.domain.interfaces;

import com.amazen._core.annotations.Contract;
import com.amazen._multipay.domain.entities.Transaction;

@Contract
public interface Observer {
    void update(Transaction transaction);
}
