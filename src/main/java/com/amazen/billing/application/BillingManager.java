package com.amazen.billing.application;

import com.amazen.billing.domain.PaymentService;
import com.amazen.billing.domain.Status;
import com.amazen.billing.domain.Subscription;
import com.amazen.billing.domain.SubscriptionService;
import com.amazen.billing.exposition.SubscriptionsResponse;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.annotations.Manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Logger;

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

    public void subscriptionRenewal(){
        Collection<Subscription> subscriptionsToRenew = subscriptionService.getSubscriptionsToRenew();
        if(Objects.nonNull(subscriptionsToRenew) && !subscriptionsToRenew.isEmpty()){
            subscriptionsToRenew.forEach(this::openTransaction);
        }else{
            logger.info("None subscription to renew");
        }

    }

    public SubscriptionsResponse getExpiringSubscriptions(){

        return new SubscriptionsResponse(new ArrayList<>());
    }
}
