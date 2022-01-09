package com.amazen.billing.domain;

import com.amazen.kernel.annotations.Service;
import com.amazen.billing.application.CreateSubscriptionEvent;
import com.amazen.billing.infrastructure.SubscriptionInMemoryRepository;

import java.util.*;

@Service
public class SubscriptionService {

    private final SubscriptionInMemoryRepository repository;

    public SubscriptionService(SubscriptionInMemoryRepository repository) {
        this.repository = repository;
    }

    public Subscription createFrom(CreateSubscriptionEvent event){
        return Subscription.create(event.getMemberID());
    }

    public Subscription save(Subscription subscription){
        return repository.save(subscription);
    }

    public Collection<Subscription> getSubscriptionsToRenew(){
        Collection<Subscription> allToRenew = repository.findAllToRenew();
        return allToRenew;
    }
}
