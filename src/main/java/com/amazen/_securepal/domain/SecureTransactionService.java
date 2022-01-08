package com.amazen._securepal.domain;

import com.amazen._kernel.abstracts.Repository;
import com.amazen._kernel.abstracts.Service;

public class SecureTransactionService implements Service {

    private final Repository<TransactionId, Transaction> repository;

    public SecureTransactionService(Repository<TransactionId, Transaction> repository) {
        this.repository = repository;
    }

    public Transaction process(Transaction request) throws InterruptedException {
        var res = repository.save(request);
        Thread.sleep(2000);
        return res;
    }
}
