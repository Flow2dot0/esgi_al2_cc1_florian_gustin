package com.amazen._subscription;

import java.net.URISyntaxException;

public interface PaymentFacade {
    public TransactionDto pay(TransactionDto dto) throws URISyntaxException;
}
