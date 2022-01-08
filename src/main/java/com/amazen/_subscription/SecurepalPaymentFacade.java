package com.amazen._subscription;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class SecurepalPaymentFacade implements PaymentFacade {

    @Override
    public TransactionDto pay(TransactionDto dto) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .POST()
                .build();
    }
}
