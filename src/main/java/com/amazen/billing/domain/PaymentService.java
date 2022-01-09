package com.amazen.billing.domain;

import com.amazen.kernel.annotations.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

@Service
public class PaymentService implements com.amazen.kernel.Service {

    private final Logger logger;

    public PaymentService(Logger logger) {
        this.logger = logger;
    }

    public Subscription pay(Subscription subscription){
        // random success payment or fail
        final Integer headsOrTail = ThreadLocalRandom.current().nextInt(0, 1 + 1);

        Transaction response;
        if(headsOrTail.equals(1)){
            // stub for successing payment
            subscription.setBank(new Bank(1212121212121212L, CardType.VISA, LocalDate.of(2025, 12, 1), 123));
            response = new Transaction(TransactionID.of(ThreadLocalRandom.current().nextInt(1, 100000 + 1)), subscription.getAmount(), Status.SUCCESS, LocalDate.now());
        }else{
            // stub for failing payment
            subscription.setBank(new Bank(1212121212121212L, CardType.MASTERCARD, LocalDate.of(2019, 12, 1), 123));
            response = new Transaction(TransactionID.of(ThreadLocalRandom.current().nextInt(1, 100000 + 1)), subscription.getAmount(), Status.FAIL, LocalDate.now());
        }
        subscription.setDate(response.getDate());
        subscription.setStatus(response.getStatus());
        subscription.setTransactionID(response.getId());
        return subscription;
    }


}
