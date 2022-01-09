package com.amazen.billing.application;

import com.amazen.billing.domain.PaymentService;
import com.amazen.billing.domain.Status;
import com.amazen.billing.domain.Subscription;
import com.amazen.billing.domain.SubscriptionService;
import com.amazen.billing.exposition.SubscriptionResponse;
import com.amazen.billing.exposition.SubscriptionsResponse;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.annotations.Manager;

import java.util.*;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Manager
public class BillingManager {

    private final SubscriptionService subscriptionService;
    private final PaymentService paymentService;
    private final Logger logger;

    public BillingManager(SubscriptionService subscriptionService, PaymentService paymentService, Logger logger) {
        this.subscriptionService = subscriptionService;
        this.paymentService = paymentService;
        this.logger = logger;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }


    public void openPaymentTransaction(CreateSubscriptionEvent event){
        final Subscription subscription = subscriptionService.createFrom(event);
        openTransaction(subscription);
    }

    public void openTransaction(Subscription subscription){
        Subscription sp = paymentService.pay(subscription);
        if(sp.getStatus().equals(Status.SUCCESS)){
            logger.info("Payment accepted, registering the subscription");
            subscriptionService.save(sp);
        }else{
            logger.warning("Payment denied, please contact your bank");
        }
    }

    public Collection<Subscription> subscriptionRenewal(){
        Collection<Subscription> subscriptionsToRenew = subscriptionService.getSubscriptionsToRenew();
        if(Objects.nonNull(subscriptionsToRenew) && !subscriptionsToRenew.isEmpty()){
            subscriptionsToRenew.forEach(this::openTransaction);
        }else{
            logger.info("None subscription to renew");
        }
        return subscriptionsToRenew;

    }

    public SubscriptionsResponse getExpiringSubscriptions(){
        Collection<Subscription> subscriptions = subscriptionRenewal();
        List<SubscriptionResponse> responses = new ArrayList<>();
        if(subscriptions != null){
            responses.addAll(subscriptions.stream().map(subscription -> {
              return new SubscriptionResponse(subscription.getId().getId(), subscription.getAmount().getValue(), subscription.getStatus().getValue());
            }).collect(Collectors.toList()));
        }
        return new SubscriptionsResponse(responses);
    }
}
