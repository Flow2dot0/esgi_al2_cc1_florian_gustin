package com.amazen.subscription.application;

import com.amazen.kernel.CommandBus;
import com.amazen.kernel.annotations.Manager;
import com.amazen.subscription.domain.PaymentService;
import com.amazen.subscription.domain.Subscription;
import com.amazen.subscription.domain.SubscriptionService;

@Manager
public class SubscriptionManager {

    private final SubscriptionService subscriptionService;
    private final PaymentService paymentService;
    private final CommandBus commandBus;

    public SubscriptionManager(SubscriptionService subscriptionService, PaymentService paymentService, CommandBus commandBus) {
        this.subscriptionService = subscriptionService;
        this.paymentService = paymentService;
        this.commandBus = commandBus;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }

    public void openPaymentTransaction(CreateSubscriptionEvent event){
        final Subscription subscription = subscriptionService.createFrom(event);
        Subscription sp = paymentService.pay(subscription);
        subscriptionService.save(sp);
    }
}
