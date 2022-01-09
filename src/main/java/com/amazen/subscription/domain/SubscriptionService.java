package com.amazen.subscription.domain;

import com.amazen.kernel.annotations.Service;
import com.amazen.subscription.application.CreateSubscriptionEvent;
import com.amazen.subscription.infrastructure.SubscriptionInMemoryRepository;

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
}
