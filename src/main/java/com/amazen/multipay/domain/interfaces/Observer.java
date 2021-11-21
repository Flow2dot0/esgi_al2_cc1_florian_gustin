package com.amazen.multipay.domain.interfaces;

import com.amazen.core.annotations.Contract;
import com.amazen.multipay.domain.entities.Transaction;

@Contract
public interface Observer {
    void update(Transaction transaction);
}
